package br.com.osmarsouza.api.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import br.com.osmarsouza.api.model.DadosReparo;
import br.com.osmarsouza.api.model.EmptyJsonResponse;
import br.com.osmarsouza.api.model.OS;
import br.com.osmarsouza.api.model.SituacaoOS;
import br.com.osmarsouza.api.model.TipoSituacao;
import br.com.osmarsouza.api.model.Users;
import br.com.osmarsouza.api.repository.DadosReparoRepository;
import br.com.osmarsouza.api.repository.OSRepository;
import br.com.osmarsouza.api.repository.SituacaoRepository;

@RestController
@RequestMapping("os")
public class OSController {
	
	@Autowired
	private OSRepository repository;
	
	@Autowired
	private SituacaoRepository situacaoRepository;
	
	@Autowired
	private DadosReparoRepository dadosReparoRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, params = {"page", "offset"})
	public Page<OS> getAllOSByData(
			@RequestParam("page") int page, 
			@RequestParam("offset") int offset) {
	
		System.out.println("Os valores são " + page + " e " + offset);
		
		PageRequest pageRequest = new PageRequest(page - 1, offset);
		
		return repository.getAllOSByCreated_at(pageRequest);		
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"page", "offset", "idpessoa"})
	public Page<OS> getAllOSByPessoa(@RequestParam("page") int page, 
			@RequestParam("offset") int offset,
			@RequestParam("idpessoa") long idpessoa) {
	
		System.out.println("Os valores são " + page + " e " + offset);
		
		PageRequest pageRequest = new PageRequest(page - 1, offset);
		
		return repository.getAllOSByPessoa(pageRequest, idpessoa );		
	}
	
	
	@RequestMapping("/{id}")
	public OS getOSById(@PathVariable("id")  long id) {
		return repository.findOne(id);
	}
	
		
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<OS> addOS(@RequestBody OS os) {
		
		os.setCreated_at(new Date());
		
		OS novaOS = repository.save(os);
		
		SituacaoOS situacao = new SituacaoOS(novaOS.getId(), TipoSituacao.TIPO_SITUACAO_AORCAR, 1 );
		
		situacaoRepository.save(situacao);
	
	
		return new ResponseEntity<OS>(novaOS, HttpStatus.CREATED);
		
	}
	
	/*---------------------------------------------------------------------------------------------------
	 * 
	 *                                     SITUAÇÕES
	 * 
	 *---------------------------------------------------------------------------------------------------*/
	

	@RequestMapping("/{id}/situacoes")
	public List<SituacaoOS> getSituacoes(@PathVariable long id) {
		return situacaoRepository.getAllByos_id(id);
		
	}	
	
	@RequestMapping(value="/{id}/situacoes", method=RequestMethod.POST)
	public ResponseEntity<SituacaoOS> addStiaucao(@RequestBody SituacaoOS situacao) {
		
		Users usuario = new Users();
		usuario.setId(1L);
		situacao.setUsuario(usuario);
		
		System.out.println("A situacao passada é: ");
		//System.out.println(situacao.getOs_id());
		System.out.println(situacao.getTipoSituacao().getId());
		
		
		return new ResponseEntity<SituacaoOS>(situacaoRepository.save(situacao), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}/situacoes", method=RequestMethod.PUT)
	public ResponseEntity<SituacaoOS> deleteSituacao(@RequestBody SituacaoOS situacao) {
		
		//A exclusão é lógica
		
		situacao.setDeleted_at(new Date());
		
		return new ResponseEntity<SituacaoOS>(situacaoRepository.save(situacao), HttpStatus.OK);
	}
		
	
	/*---------------------------------------------------------------------------------------------------
	 * 
	 *                                     DADOS REPARO
	 * 
	 *---------------------------------------------------------------------------------------------------*/
	
	@RequestMapping("/{id}/dadosreparo")
	public ResponseEntity<?> getDadosReparo(@PathVariable long id) {
		DadosReparo dadosReparo = dadosReparoRepository.findByos_id(id);
		
		if(dadosReparo != null)
		   return new ResponseEntity<>(dadosReparo, HttpStatus.OK);
		else
		   return new ResponseEntity<>(new EmptyJsonResponse(), HttpStatus.OK);	
		
	}
	
	@RequestMapping(value="/{id}/dadosreparo", method=RequestMethod.POST)
	public ResponseEntity<DadosReparo> addDadosReparo(@RequestBody DadosReparo dadosReparo) {
		return new ResponseEntity<DadosReparo>(dadosReparoRepository.save(dadosReparo), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value="/{id}/dadosreparo", method=RequestMethod.PUT)
	public ResponseEntity<DadosReparo> updateDadosReparo(@RequestBody DadosReparo dadosReparo) {
		return new ResponseEntity<DadosReparo>(dadosReparoRepository.save(dadosReparo), HttpStatus.OK);
		
	}
}
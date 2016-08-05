package br.com.osmarsouza.api.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
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
	public Page<OS> getAllOSByData(@RequestParam("page") int page, @RequestParam("offset") int offset) {
	
		System.out.println("Os valores são " + page + " e " + offset);
		
		PageRequest pageRequest = new PageRequest(page - 1, 15);
		
		return repository.getAllOSByCreated_at(pageRequest);		
	}
	
	
	@RequestMapping("/{id}")
	public OS getOSById(@PathVariable("id")  long id) {
		return repository.findOne(id);
	}
	
	
	@RequestMapping("/{id}/situacoes")
	public List<SituacaoOS> getSituacoes(@PathVariable long id) {
		return situacaoRepository.getAllByos_id(id);
		
	}
	
	@RequestMapping("/{id}/dadosreparo")
	public ResponseEntity<?> getDadosReparo(@PathVariable long id) {
		DadosReparo dadosReparo = dadosReparoRepository.findByos_id(id);
		
		if(dadosReparo != null)
		   return new ResponseEntity<>(dadosReparo, HttpStatus.OK);
		else
		   return new ResponseEntity<>(new EmptyJsonResponse(), HttpStatus.OK);	
		
	}	
}
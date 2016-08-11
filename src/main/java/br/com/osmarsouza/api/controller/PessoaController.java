package br.com.osmarsouza.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.osmarsouza.api.model.OS;
import br.com.osmarsouza.api.model.Pessoa;
import br.com.osmarsouza.api.model.VWPessoaWithOS;
import br.com.osmarsouza.api.repository.PessoaRepository;
import br.com.osmarsouza.api.repository.VWPessoaWithOSRepository;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@Autowired
	private VWPessoaWithOSRepository vwPessoaWithOSRepository;
	
	
	@RequestMapping(method = RequestMethod.GET, params = {"page", "offset"})
	public Page<VWPessoaWithOS> getAll(@RequestParam("page") int page, @RequestParam("offset") int offset) {
	
		
		PageRequest pageRequest = new PageRequest(page - 1, offset, Sort.Direction.ASC, "nome");
		
		return vwPessoaWithOSRepository.findAll(pageRequest);		
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"page", "offset", "nome"})
	public Page<VWPessoaWithOS> getAllByNome(
			@RequestParam("page") int page, 
			@RequestParam("offset") int offset,
			@RequestParam("nome") String nome){
	
		
		PageRequest pageRequest = new PageRequest(page - 1, offset, Sort.Direction.ASC, "nome");
		
		return vwPessoaWithOSRepository.findByNomeContaining(pageRequest, nome.toUpperCase());		
	}
	
	@RequestMapping(method = RequestMethod.GET, params = {"page", "offset", "telefone"})
	public Page<VWPessoaWithOS> getAllByTelefone(
			@RequestParam("page") int page, 
			@RequestParam("offset") int offset,
			@RequestParam("telefone") String telefone){
	
		
		PageRequest pageRequest = new PageRequest(page - 1, offset, Sort.Direction.ASC, "nome");
		
		return vwPessoaWithOSRepository.findByTelefoneContaining(pageRequest, telefone);		
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Pessoa>> getAllPessoas() {
		return new ResponseEntity<>((Collection<Pessoa>) repository.findAll(), HttpStatus.OK);
	}
	
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Pessoa> getPessoaWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPessoa(@RequestBody Pessoa input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<?> updatePessoa(@RequestBody Pessoa input) {
    	return new ResponseEntity<>(repository.save(input), HttpStatus.OK);
    }


}

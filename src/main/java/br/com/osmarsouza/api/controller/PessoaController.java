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
import br.com.osmarsouza.api.repository.PessoaRepository;

@RestController
@RequestMapping("pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, params = {"page", "offset"})
	public Page<Pessoa> getAll(@RequestParam("page") int page, @RequestParam("offset") int offset) {
	
		
		PageRequest pageRequest = new PageRequest(page - 1, offset, Sort.Direction.ASC, "nome");
		
		return repository.findAll(pageRequest);		
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Pessoa>> getAllPessoas() {
		return new ResponseEntity<>((Collection<Pessoa>) repository.findAll(), HttpStatus.OK);
	}
	
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Pessoa> getPessoaWithId(@PathVariable Long id) {
        return new ResponseEntity<>(repository.findOne(id),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, params = {"nome"})
    public ResponseEntity<Collection<Pessoa>> findPieWithName(@RequestParam(value="nome") String nome) {
        //return new ResponseEntity<>(repository.findPessoaWithPartOfName(nome), HttpStatus.OK);
    	return new ResponseEntity<>(repository.findByNomeContaining(nome), HttpStatus.OK);
    	
    }	
	
	
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addPessoa(@RequestBody Pessoa input) {
        return new ResponseEntity<>(repository.save(input), HttpStatus.CREATED);
    }

}

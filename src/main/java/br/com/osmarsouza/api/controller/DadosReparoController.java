package br.com.osmarsouza.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.osmarsouza.api.model.DadosReparo;
import br.com.osmarsouza.api.repository.DadosReparoRepository;

@RestController
@RequestMapping("dadosreparo")
public class DadosReparoController {
	
	@Autowired
	private DadosReparoRepository repository;
	
    @RequestMapping("/{id}")
	public ResponseEntity<DadosReparo> getDadosReparoPoros_id(@PathVariable long id) {
    	return new ResponseEntity<>(repository.findByos_id(id), HttpStatus.OK);
    }
}
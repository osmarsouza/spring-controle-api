package br.com.osmarsouza.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.osmarsouza.api.model.Marca;
import br.com.osmarsouza.api.repository.MarcaRepository;

@RestController
@RequestMapping("marcas")
public class MarcaController {
	
	@Autowired
	private MarcaRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Marca>> getAll() {
		return new ResponseEntity<>((Collection<Marca>) repository.findAll(), HttpStatus.OK);
	}

}

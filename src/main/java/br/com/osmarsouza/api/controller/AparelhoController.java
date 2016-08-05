package br.com.osmarsouza.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.osmarsouza.api.model.Aparelho;
import br.com.osmarsouza.api.repository.AparelhoRepository;

@RestController
@RequestMapping("aparelhos")
public class AparelhoController {
	
	@Autowired
	private AparelhoRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<Aparelho>> getAll() {
		return new ResponseEntity<>((Collection<Aparelho>) repository.findAll(), HttpStatus.OK);
	}

}

package br.com.osmarsouza.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.osmarsouza.api.model.TipoSituacao;
import br.com.osmarsouza.api.repository.TipoSituacaoRepository;

@RestController
@RequestMapping("tiposSituacao")
public class TipoSituacaoController {
	
	@Autowired
	private TipoSituacaoRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Collection<TipoSituacao>> getAll() {
		return new ResponseEntity<>((Collection<TipoSituacao>) repository.findAll(), HttpStatus.OK);
	}

}

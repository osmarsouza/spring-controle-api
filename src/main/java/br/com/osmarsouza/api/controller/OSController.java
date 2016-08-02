package br.com.osmarsouza.api.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.osmarsouza.api.model.OS;
import br.com.osmarsouza.api.repository.OSRepository;

@RestController
@RequestMapping("os")
public class OSController {
	
	@Autowired
	private OSRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, params = {"page", "offset"})
	public ResponseEntity<Collection<OS>> getAllOSByData(@RequestParam(value="page") int page, @RequestParam(value="offset") int offset) {
	
		System.out.println("Os valores são " + page + " e " + offset);
		
		return new ResponseEntity<>((Collection<OS>) repository.getAllOSByData(new PageRequest(page, offset )), HttpStatus.OK);
	}
}


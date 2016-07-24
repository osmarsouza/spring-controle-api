package br.com.osmarsouza.api.controller;

import br.com.osmarsouza.api.service.AbstractService;
import br.com.osmarsouza.api.service.TesteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.osmarsouza.api.model.Teste;

@RestController
@RequestMapping("teste")
public class TesteController extends AbstractController<Teste, Long> {

	@Autowired
	private TesteService testeService;

	@Override
	protected AbstractService<Teste, Long> getService() {
		return testeService;
	}

}

package br.com.osmarsouza.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.osmarsouza.api.repository.PessoaRepository;
import br.com.osmarsouza.dto.PessoaDTO;
import br.com.osmarsouza.util.NativeQueryResultToBean;

@Service
public class PessoaService {
	
	@Autowired
	PessoaRepository repository;
	
	public List<PessoaDTO> getPessoaComQtdOS(@PathVariable Integer id) throws ClassNotFoundException {
		
    	List<Object[]> records = repository.findByIdWithQtdOS(id);
    	
    	return NativeQueryResultToBean.map(PessoaDTO.class, records);

	}
    	

}

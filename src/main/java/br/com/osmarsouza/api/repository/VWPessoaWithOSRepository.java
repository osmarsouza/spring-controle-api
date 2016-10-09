package br.com.osmarsouza.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.osmarsouza.api.model.Pessoa;
import br.com.osmarsouza.api.model.VWPessoaWithOS;

public interface VWPessoaWithOSRepository extends CrudRepository<VWPessoaWithOS, Long> {
	
	Page<VWPessoaWithOS> findAll(Pageable pageable);
	
	Page<VWPessoaWithOS> findByNomeContaining(Pageable pageable, String nome);

	Page<VWPessoaWithOS> findByTelefoneContaining(Pageable pageable, String telefone);
}




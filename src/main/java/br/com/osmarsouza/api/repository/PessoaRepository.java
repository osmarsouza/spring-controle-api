package br.com.osmarsouza.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.osmarsouza.api.model.Pessoa;

/*
@RequestMapping(produces = { "application/xml" })
@RepositoryRestResource(collectionResourceRel = "pessoa", path = "pessoa")
public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long> {

}
*/
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	List<Pessoa> findByNome(String nome);
	
	Page<Pessoa> findAll(Pageable pageAble);
		
	List<Pessoa> findByNomeContaining(String nome);
	List<Pessoa> findByTelefoneContaining(String telefone);
	
	List<Pessoa> findByNomeLike(String nome);
	List<Pessoa> findByNomeStartingWith(String nome);
	List<Pessoa> findByNomeEndingWith(String nome);

}


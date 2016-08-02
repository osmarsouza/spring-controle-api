package br.com.osmarsouza.api.repository;

import java.util.List;

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
	
	@Query("SELECT p FROM Pessoa p WHERE p.nome LIKE CONCAT('%',:nome,'%')")
	List<Pessoa> findPessoaWithPartOfName(@Param("nome") String nome);

}

package br.com.osmarsouza.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.osmarsouza.api.model.SituacaoOS;


@RepositoryRestResource(collectionResourceRel = "situacoes", path = "situacoes")
public interface SituacaoRepository extends PagingAndSortingRepository<SituacaoOS, Long> {

	@Query("SELECT so FROM SituacaoOS so where so.os_id = :os_id AND so.deleted_at is null")
	List<SituacaoOS> getAllByos_id(@Param("os_id") long os_id);
}
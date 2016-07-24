package br.com.osmarsouza.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.osmarsouza.api.model.OS;


@RepositoryRestResource(collectionResourceRel = "os", path = "os")
public interface OSRepository extends PagingAndSortingRepository<OS, Long> {

    //List<Pessoa> findByNome(@Param("nome") String nome);

}


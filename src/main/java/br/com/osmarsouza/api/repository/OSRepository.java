package br.com.osmarsouza.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.osmarsouza.api.model.OS;
import br.com.osmarsouza.api.model.Pessoa;


public interface OSRepository extends JpaRepository<OS, Long> {
	
	@Query("SELECT O FROM OS O ORDER BY O.created_at Desc")
	Page<OS> getAllOSByCreated_at(Pageable pageable); 

}





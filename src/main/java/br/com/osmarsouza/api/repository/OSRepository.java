package br.com.osmarsouza.api.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import br.com.osmarsouza.api.model.OS;
import br.com.osmarsouza.api.model.Pessoa;


public interface OSRepository extends CrudRepository<OS, Long> {
	
	final String getAllPostsByRank= "from OS order by created_at DESC";
	
	OS findOne(Long primaryKey);
	
	@Query("SELECT P.nome, P.telefone, O, A.aparelho, M.nome_marca"
			+ " FROM OS O "
			+ " inner join O.pessoa P "
			+ " inner join O.aparelho A "
			+ " inner join O.marca M")
	List<OS> getAllOSByData(Pageable pageable); 

}




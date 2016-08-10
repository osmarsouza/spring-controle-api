package br.com.osmarsouza.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.osmarsouza.api.model.OS;


public interface OSRepository extends JpaRepository<OS, Long> {
	
	@Query("SELECT O FROM OS O ORDER BY O.created_at Desc")
	Page<OS> getAllOSByCreated_at(Pageable pageable); 
	
	@Query("SELECT o FROM OS AS o WHERE o.pessoa.id = :idpessoa ORDER BY o.created_at Desc")
	Page<OS> getAllOSByPessoa(Pageable pageable, @Param("idpessoa") long idpessoa);
	
	/*
	@Query("INSERT INTO os (idPessoa, aparelho_id, marca_id, modelo, numeroserie, defeitoreclamado, " +
  	    	       "observacoes, tipogarantia_id, os_anterior_id, created_at, retirado, data, externa, updated_at) " +
				   "VALUES (?, ?, ?, ?, ?, ?, ?, ? , ?, Current_TimeStamp, 'N', current_timeStamp, 'N', current_timeStamp")
	*/

}












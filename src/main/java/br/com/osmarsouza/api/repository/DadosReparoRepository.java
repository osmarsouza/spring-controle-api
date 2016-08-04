package br.com.osmarsouza.api.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.osmarsouza.api.model.DadosReparo;

public interface DadosReparoRepository extends CrudRepository<DadosReparo, Long> {
	
	@Query("SELECT dr FROM DadosReparo dr where dr.os_id = :os_id AND dr.deleted_at is null")
	DadosReparo findByos_id(@Param("os_id") long os_id); 

}

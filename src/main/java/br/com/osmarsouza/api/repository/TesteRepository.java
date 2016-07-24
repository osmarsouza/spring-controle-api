package br.com.osmarsouza.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.osmarsouza.api.model.Teste;

@Repository
public interface TesteRepository extends JpaRepository<Teste, Long> {

}


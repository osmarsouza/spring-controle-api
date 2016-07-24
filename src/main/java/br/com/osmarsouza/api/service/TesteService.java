package br.com.osmarsouza.api.service;

import br.com.osmarsouza.api.model.Teste;
import br.com.osmarsouza.api.repository.TesteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TesteService extends AbstractService<Teste, Long> {

    @Autowired
    private TesteRepository testeRepository;

    @Override
    protected JpaRepository<Teste, Long> getRepository() {
        return testeRepository;
    }

}

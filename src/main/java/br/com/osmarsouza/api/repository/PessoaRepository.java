package br.com.osmarsouza.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
	
	@Query(value="SELECT p.idpessoa as id, p.nome, p.cpf_cnpj as cpfCnpj, Count(*) "
			+ " FROM pessoa p, os o"
			+ " where p.idpessoa = :id"
			+ " and p.idpessoa = o.idpessoa"
			+ " group by p.idpessoa, nome", nativeQuery = true)
	List<Object[]> findByIdWithQtdOS(@Param("id") Integer id);
}


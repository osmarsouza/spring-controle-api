package br.com.osmarsouza.api.repository;

import br.com.osmarsouza.api.model.Users;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<Users, Long> {

    List<Users> findByName(@Param("name") String name);

}

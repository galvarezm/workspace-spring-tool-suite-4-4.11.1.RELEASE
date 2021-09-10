package cl.apiux.springboot.app.user.server.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import cl.apiux.springboot.app.user.common.models.entity.User;

@RepositoryRestResource(path="users")
public interface IUserDao extends PagingAndSortingRepository<User, Integer>{

	@RestResource(path="search-username")
	public User findByUsername(@Param("username") String username);
	
	@Query(
		nativeQuery = true,
		value = "select * from Users as u where u.username = :username"
	)
	public User getUserByUserName(@Param("username") String username);
	
}

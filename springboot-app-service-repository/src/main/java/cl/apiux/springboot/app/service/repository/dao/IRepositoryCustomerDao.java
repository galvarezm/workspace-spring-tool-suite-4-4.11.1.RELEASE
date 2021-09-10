package cl.apiux.springboot.app.service.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.apiux.springboot.app.service.repository.models.Customer;

@Repository("customerRepository")
public interface IRepositoryCustomerDao extends CrudRepository<Customer, Long> {

	@Query("from Customer where rut=?1")
	public Customer searchByRut(@Param("rut") String rut);
	
}

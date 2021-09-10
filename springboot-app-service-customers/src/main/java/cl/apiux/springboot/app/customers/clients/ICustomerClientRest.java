package cl.apiux.springboot.app.customers.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.apiux.springboot.app.customers.models.Customer;

@FeignClient(name = "repository-service", url = "localhost:8081")
public interface ICustomerClientRest {

	@GetMapping("/api/customer/list")
	public List<Customer> listCustomer();
	
}

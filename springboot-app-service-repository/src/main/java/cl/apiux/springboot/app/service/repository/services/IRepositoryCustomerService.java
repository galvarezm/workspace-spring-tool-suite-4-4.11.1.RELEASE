package cl.apiux.springboot.app.service.repository.services;

import java.util.List;

import cl.apiux.springboot.app.service.repository.models.Customer;

public interface IRepositoryCustomerService {

	public List<Customer> getCustomerList();
	public boolean canCustomerOperate(String rut);

}

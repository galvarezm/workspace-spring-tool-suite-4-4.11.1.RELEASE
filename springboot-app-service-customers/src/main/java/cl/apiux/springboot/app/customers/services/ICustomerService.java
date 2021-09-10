package cl.apiux.springboot.app.customers.services;

import java.util.List;

import cl.apiux.springboot.app.customers.models.Customer;

public interface ICustomerService {
	
	public List<Customer> getCustomerList();
	public boolean canCustomerOperate(String rut);

}

package cl.apiux.springboot.app.customers.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import cl.apiux.springboot.app.customers.clients.ICustomerClientRest;
import cl.apiux.springboot.app.customers.models.Customer;

@Service("serviceFeign")
public class CustomerServiceFeign implements ICustomerService {
	
	@Autowired
	private ICustomerClientRest clientRest;

	@Override
	public List<Customer> getCustomerList() {
		return clientRest.listCustomer();
	}

	@Override
	public boolean canCustomerOperate(String rut) {
		return false;
	}

}

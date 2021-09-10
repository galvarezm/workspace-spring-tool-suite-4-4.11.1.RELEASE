package cl.apiux.springboot.app.customers.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cl.apiux.springboot.app.customers.models.Customer;
import cl.apiux.springboot.app.customers.services.ICustomerService;

@RestController
public class CustomerController {
	
	private final Logger log = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
	
	@Autowired
	@Qualifier("serviceFeign")
	private ICustomerService serviceRest;

	
	@GetMapping("/list")
	public List<Customer> getList() {
		//return serviceRest.getCustomerList();
		return cbFactory.create("customer_list")
			.run(
				() -> serviceRest.getCustomerList()
				,e -> getListAlternative(e)
			);
	}
	private List<Customer> getListAlternative(Throwable e) {
		log.info(String.format("Exception|Detail=%s", e.toString())); 
		return new ArrayList<Customer>();
	}

	
	@GetMapping("/can-operate/{rut}")
	public boolean canOperate(@PathVariable String rut) {
		// return serviceRest.canCustomerOperate(rut);
		return cbFactory.create("customer_can_operate")
				.run(
					() -> serviceRest.canCustomerOperate(rut)
					,e -> canOperateAlternative(rut, e)
				);

	}
	private boolean canOperateAlternative(String rut, Throwable e) {
		log.info(String.format("Exception|Detail=%s", e.toString()));
		return false;
	}

}

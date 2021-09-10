package cl.apiux.springboot.app.service.repository.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.apiux.springboot.app.service.repository.models.Customer;
import cl.apiux.springboot.app.service.repository.services.IRepositoryCustomerService;

@RestController
@RequestMapping("/api/customer")
public class RepositoryCustomerController {
	
	@Autowired
	private IRepositoryCustomerService customerService;

	@CrossOrigin
	@GetMapping("/list")
	public ResponseEntity<List<Customer>> listCustomer(){
		List<Customer> result = customerService.getCustomerList();
		if (result != null) {
			return new ResponseEntity<List<Customer>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}
	
	@CrossOrigin
	@GetMapping("/can_operated/{rut}")
	public ResponseEntity canOperated(@PathVariable String rut) {
		boolean result = customerService.canCustomerOperate(rut);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}

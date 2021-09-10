package cl.apiux.springboot.app.service.repository.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.apiux.springboot.app.service.repository.models.Order;
import cl.apiux.springboot.app.service.repository.services.IRepositoryOrderService;

@RestController
@RequestMapping("/api/order")
public class RepositoryOrderController {

	@Autowired
	private IRepositoryOrderService orderService;
	
	@CrossOrigin
	@GetMapping("/list")
	public ResponseEntity<List<Order>> listCustomer(){
		List<Order> result = orderService.getOrderList();
		if (result != null) {
			return new ResponseEntity<List<Order>>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
	}

	@CrossOrigin
	@PutMapping("/create")
	public ResponseEntity<Order> createOrder(Order order) {
		Order result = orderService.createOrder(order);
		if (result != null) {
			return new ResponseEntity<Order>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}

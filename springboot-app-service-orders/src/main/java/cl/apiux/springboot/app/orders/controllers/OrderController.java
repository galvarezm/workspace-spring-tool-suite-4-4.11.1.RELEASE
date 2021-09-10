package cl.apiux.springboot.app.orders.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.apiux.springboot.app.orders.models.Order;
import cl.apiux.springboot.app.orders.services.IOrderService;

@RestController
public class OrderController {

	private final Logger log = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
	
	
	@Autowired
	@Qualifier("serviceFeign")
	private IOrderService serviceRest;

	@GetMapping("/list")
	public List<Order> getList() {
		// return serviceRest.getOrderList();
		return cbFactory.create("order_list")
				.run(
					() -> serviceRest.getOrderList()
					,e -> getListAlternative(e)
				);
	}
	private List<Order> getListAlternative(Throwable e){
		log.info(String.format("Exception|Detail=%s", e.toString()));
		return new ArrayList<Order>();
	}
	
	
	@PutMapping("/create")
	public Order createOrder(Order order) {
		// return serviceRest.createOrder(order);
		return cbFactory.create("order_list")
				.run(
					() -> serviceRest.createOrder(order)
					,e -> createOrderAlternative(order, e)
				);
	}
	private Order createOrderAlternative(Order order, Throwable e) {
		log.info(String.format("Exception|Detail=%s", e.toString()));
		return new Order();
	}

}

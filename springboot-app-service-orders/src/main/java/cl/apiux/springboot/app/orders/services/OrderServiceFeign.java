package cl.apiux.springboot.app.orders.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.apiux.springboot.app.orders.clients.IOrderClientRest;
import cl.apiux.springboot.app.orders.models.Order;

@Service("serviceFeign")
public class OrderServiceFeign implements IOrderService {
	
	@Autowired
	private IOrderClientRest clientRest;

	@Override
	public List<Order> getOrderList() {
		return clientRest.listOrder();
	}

	@Override
	public Order createOrder(Order order) {
		return new Order();
	}

}

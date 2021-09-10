package cl.apiux.springboot.app.orders.services;

import java.util.List;

import cl.apiux.springboot.app.orders.models.Order;

public interface IOrderService {
	
	public List<Order> getOrderList();
	public Order createOrder(Order order);

}

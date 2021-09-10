package cl.apiux.springboot.app.service.repository.services;

import java.util.List;

import cl.apiux.springboot.app.service.repository.models.Order;

public interface IRepositoryOrderService {

	public List<Order> getOrderList();
	public Order createOrder(Order order);

}

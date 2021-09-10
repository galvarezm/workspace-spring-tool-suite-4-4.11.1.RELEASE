package cl.apiux.springboot.app.service.repository.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.apiux.springboot.app.service.repository.dao.IRepositoryOrderDao;
import cl.apiux.springboot.app.service.repository.models.Order;

@Service
public class RepositoryOrderServiceImpl implements IRepositoryOrderService {

	@Autowired
	private IRepositoryOrderDao repositoryDao;
	
	@Override
	public List<Order> getOrderList() {
		return (List<Order>) repositoryDao.findAll();
	}

	@Override
	public Order createOrder(Order order) {
		return repositoryDao.save(order);
	}

}

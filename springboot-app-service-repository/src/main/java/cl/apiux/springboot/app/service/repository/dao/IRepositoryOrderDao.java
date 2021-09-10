package cl.apiux.springboot.app.service.repository.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.apiux.springboot.app.service.repository.models.Order;

@Repository("orderRepository")
public interface IRepositoryOrderDao extends CrudRepository<Order, Long> {

}

package cl.apiux.springboot.app.orders.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.apiux.springboot.app.orders.models.Order;

@FeignClient(name = "repository-service", url = "localhost:8081")
public interface IOrderClientRest {

	@GetMapping("/api/order/list")
	public List<Order> listOrder();

}

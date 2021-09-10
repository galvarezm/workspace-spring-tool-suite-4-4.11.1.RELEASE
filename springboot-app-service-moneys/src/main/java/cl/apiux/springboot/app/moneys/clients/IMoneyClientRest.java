package cl.apiux.springboot.app.moneys.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import cl.apiux.springboot.app.moneys.models.Money;

@FeignClient(name = "repository-service", url = "localhost:8081")
public interface IMoneyClientRest {

	@GetMapping("/api/money/list")
	public List<Money> listMoney();

}

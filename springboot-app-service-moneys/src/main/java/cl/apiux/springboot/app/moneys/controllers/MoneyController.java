package cl.apiux.springboot.app.moneys.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cl.apiux.springboot.app.moneys.models.Money;
import cl.apiux.springboot.app.moneys.services.IMoneyService;

@RestController
public class MoneyController {
	
	private final Logger log = LoggerFactory.getLogger(MoneyController.class);
	
	@Autowired
	private CircuitBreakerFactory cbFactory;
	
	@Autowired
	@Qualifier("serviceFeign")
	private IMoneyService serviceRest;

	
	@GetMapping("/list")
	public List<Money> getList() { 
		// return serviceRest.getMoneyList();
		return cbFactory.create("money_list")
				.run(
					() -> serviceRest.getMoneyList()
					,e -> getListAlternative(e)
				);
	}
	private List<Money> getListAlternative(Throwable e){
		log.info(String.format("Exception|Detail=%s", e.toString()));
		return new ArrayList<Money>();
	}

	
	@GetMapping("/get-price/{code}")
	public double getPrice(@PathVariable String code) {
		// return serviceRest.getMoneyPrice(code);
		return (double) cbFactory.create("money_get_price")
				.run(
					() -> serviceRest.getMoneyPrice(code)
					,e -> getPriceAlternative(code, e)
				);
	}
	private double getPriceAlternative(String code, Throwable e) {
		log.info(String.format("Exception|Detail=%s", e.toString()));
		return 0.0;
	}

}

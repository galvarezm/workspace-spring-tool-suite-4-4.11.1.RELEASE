package cl.apiux.springboot.app.moneys.services;

import java.util.List;

import cl.apiux.springboot.app.moneys.models.Money;

public interface IMoneyService {
	
	public List<Money> getMoneyList();
	public double getMoneyPrice(String code);

}

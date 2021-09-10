package cl.apiux.springboot.app.service.repository.services;

import java.util.List;

import cl.apiux.springboot.app.service.repository.models.Money;

public interface IRepositoryMoneyService {

	public List<Money> getMoneyList();
	public double getMoneyPrice(String code);

}

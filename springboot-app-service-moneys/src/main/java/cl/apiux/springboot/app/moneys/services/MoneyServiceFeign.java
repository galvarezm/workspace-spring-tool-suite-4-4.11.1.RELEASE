package cl.apiux.springboot.app.moneys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.apiux.springboot.app.moneys.clients.IMoneyClientRest;
import cl.apiux.springboot.app.moneys.models.Money;

@Service("serviceFeign")
public class MoneyServiceFeign implements IMoneyService {
	
	@Autowired
	private IMoneyClientRest clientRest;

	@Override
	public List<Money> getMoneyList() {
		return clientRest.listMoney();
	}

	@Override
	public double getMoneyPrice(String code) {
		return 0;
	}

}

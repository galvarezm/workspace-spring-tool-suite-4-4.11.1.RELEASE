package cl.apiux.springboot.app.service.repository.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.apiux.springboot.app.service.repository.dao.IRepositoryMoneyDao;
import cl.apiux.springboot.app.service.repository.models.Money;

@Service
public class RepositoryMoneyServiceImpl implements IRepositoryMoneyService {

	@Autowired
	private IRepositoryMoneyDao repositoryDao;
	
	@Override
	public List<Money> getMoneyList() {
		return (List<Money>) repositoryDao.findAll();
	}

	@Override
	public double getMoneyPrice(String code) {
		try {
			Money money = repositoryDao.searchByCode(code);
			return money.getPrice();
		} catch (Exception e) {
			return 0.0;
		}
	}

}

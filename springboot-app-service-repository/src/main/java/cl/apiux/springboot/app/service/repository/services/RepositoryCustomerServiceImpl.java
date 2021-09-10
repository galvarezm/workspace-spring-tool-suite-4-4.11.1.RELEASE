package cl.apiux.springboot.app.service.repository.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.apiux.springboot.app.service.repository.dao.IRepositoryCustomerDao;
import cl.apiux.springboot.app.service.repository.models.Customer;

@Service
public class RepositoryCustomerServiceImpl implements IRepositoryCustomerService {

	@Autowired
	private IRepositoryCustomerDao repositoryDao;

	@Override
	public List<Customer> getCustomerList() {
		return (List<Customer>) repositoryDao.findAll();
	}

	@Override
	public boolean canCustomerOperate(String rut) {
		try {
			Customer customer = repositoryDao.searchByRut(rut);
			return customer.isCanOperate();			
		} catch (Exception e) {
			return false;
		}
	}

}

package cl.apiux.springboot.app.service.repository.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.apiux.springboot.app.service.repository.models.Money;

@Repository("moneyRepository")
public interface IRepositoryMoneyDao extends CrudRepository<Money, Long> {

	@Query("from Money where code=?1")
	public Money searchByCode(@Param("code") String code);

}

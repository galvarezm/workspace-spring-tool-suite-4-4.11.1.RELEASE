package cl.apiux.springboot.app.service.repository.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order_buy")
public class Order implements Serializable {

	private static final long serialVersionUID = 980759291789236898L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date create_at;

	@Column(name = "customer_rut")
	private String customerRut;
	
	@Column(name = "money_code")
	private String moneyCode;
	
	@Column(name = "operation_type")
	private String operationType;
	
	@Column(name = "transaction_price")
	private double transactionPrice;

	@Column(name = "limit_date")
	@Temporal(TemporalType.DATE)
	private Date limitDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreate_at() {
		return create_at;
	}

	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}

	public String getCustomerRut() {
		return customerRut;
	}

	public void setCustomerRut(String customerRut) {
		this.customerRut = customerRut;
	}

	public String getMoneyCode() {
		return moneyCode;
	}

	public void setMoneyCode(String moneyCode) {
		this.moneyCode = moneyCode;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public double getTransactionPrice() {
		return transactionPrice;
	}

	public void setTransactionPrice(double transactionPrice) {
		this.transactionPrice = transactionPrice;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

}

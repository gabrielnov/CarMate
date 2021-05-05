package br.com.carmate.Carmate.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Sale {

	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long saleId;
	
	@OneToOne // TODO verify this assignment
	private Vehicle vehicle = new Vehicle();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer customer = new Customer();	
	
	private BigDecimal saleValue;

	public Long getSaleId() {
		return saleId;
	}

	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getBuyer() {
		return customer;
	}

	public void setBuyer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(BigDecimal saleValue) {
		this.saleValue = saleValue;
	}

}

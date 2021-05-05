package br.com.carmate.Carmate.model;

import java.math.BigDecimal;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Sale {

	private Long saleId;
	private Vehicle vehicle = new Vehicle();
	
	@ManyToMany
	private Buyer buyer = new Buyer();	
	
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

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public BigDecimal getSaleValue() {
		return saleValue;
	}

	public void setSaleValue(BigDecimal saleValue) {
		this.saleValue = saleValue;
	}

}

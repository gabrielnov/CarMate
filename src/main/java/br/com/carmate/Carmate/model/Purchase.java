package br.com.carmate.Carmate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long purchaseId;
	
	@OneToMany(fetch = FetchType.LAZY) // TODO verify this assignment 
	@JoinColumn(name="vehicleId")
	private List<Vehicle> vehicles = new ArrayList<>();

	@OneToOne
	private Supplier supplier = new Supplier();

	public Long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
	}	

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	public Supplier getProvider() {
		return supplier;
	}

	public void setProvider(Supplier supplier) {
		this.supplier = supplier;
	}

}

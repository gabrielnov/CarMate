package br.com.carmate.Carmate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carmate.Carmate.model.Vehicle;
import br.com.carmate.Carmate.repository.VehicleRepository;
import br.com.carmate.Carmate.repository.VehiclesSupplierRepository;

@Service
public class VehiclesService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	VehiclesSupplierRepository vehiclesSupplierRepository;
	
	public List<Vehicle> listVehicles() {		
		return vehicleRepository.findAll();
	}

	public Vehicle saveVehicle(Vehicle vehicle) {				
		return vehicleRepository.save(vehicle);
		
	}

	public Vehicle updateVehicle(Long id, Vehicle vehicle) {
		vehicle.setId(id);		
		return vehicleRepository.save(vehicle);
		
	}

	public void deleteSupplier(Long id) {
		vehicleRepository.deleteById(id);
		
	}



}

package br.com.carmate.Carmate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carmate.Carmate.model.Vehicle;
import br.com.carmate.Carmate.model.VehiclesSupplier;
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



}

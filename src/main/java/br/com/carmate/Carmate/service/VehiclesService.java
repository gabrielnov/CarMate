package br.com.carmate.Carmate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carmate.Carmate.model.Vehicle;
import br.com.carmate.Carmate.repository.VehicleRepository;

@Service
public class VehiclesService {

	@Autowired
	VehicleRepository vehicleRepository;
	
	public List<Vehicle> listVehicles() {
		
		return vehicleRepository.findAll();
	}

}

package br.com.carmate.Carmate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carmate.Carmate.model.VehiclesSupplier;
import br.com.carmate.Carmate.repository.VehiclesSupplierRepository;

@Service
public class VehiclesSuppliersService {   

	@Autowired
	VehiclesSupplierRepository vehiclesSupplierRepository;

	public List<VehiclesSupplier> listVehiclesSuppliers() {
		return vehiclesSupplierRepository.findAll();		
	}

	public Optional<VehiclesSupplier> findVehiclesSupplierById(Long id) {		
		Optional<VehiclesSupplier> vehiclesSupplier = vehiclesSupplierRepository.findById(id);
					
		return vehiclesSupplier;
		
	}
	
	public VehiclesSupplier saveSupplier(VehiclesSupplier vehiclesSupplier) {			
		return vehiclesSupplierRepository.save(vehiclesSupplier);
	}
	
	public void deleteVehiclesSupplier(Long id) {			
		vehiclesSupplierRepository.deleteById(id);		
		
	}

	public VehiclesSupplier updateVehiclesSupplier(Long id, VehiclesSupplier newSupplier) {		
		newSupplier.setId(id);
		
		return vehiclesSupplierRepository.save(newSupplier);

	}
}
	

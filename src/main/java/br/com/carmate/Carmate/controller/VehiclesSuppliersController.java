package br.com.carmate.Carmate.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carmate.Carmate.model.VehiclesSupplier;
import br.com.carmate.Carmate.repository.VehiclesSupplierRepository;
import br.com.carmate.Carmate.service.VehiclesSuppliersService;

@RestController
@RequestMapping("api/suppliers")
public class VehiclesSuppliersController {
	
	@Autowired
	private VehiclesSupplierRepository vehiclesSupplierRepository;
		
	private VehiclesSuppliersService vehiclesSuppliersService;
	
	@Autowired
	public void setSuppliersService(VehiclesSuppliersService vehiclesSuppliersService) {
		this.vehiclesSuppliersService = vehiclesSuppliersService;
	}
	
	@GetMapping
	public ResponseEntity<List<VehiclesSupplier>> listVehiclesSuppliers() {
		return ResponseEntity.ok().body(vehiclesSuppliersService.listVehiclesSuppliers());
						
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VehiclesSupplier> findVehiclesSupplierById(@PathVariable Long id) {	
		return vehiclesSuppliersService.findVehiclesSupplierById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());		
	}

	@PostMapping
	public ResponseEntity<?> newSupplier(@RequestBody VehiclesSupplier vehiclesSupplier){
		
		vehiclesSuppliersService.saveSupplier(vehiclesSupplier);		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> updateSupplier(@PathVariable Long id, @RequestBody VehiclesSupplier newVehiclesSupplier){			
		vehiclesSuppliersService.updateVehiclesSupplier(id, newVehiclesSupplier);
		return ResponseEntity.ok().build();						
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteVehiclesSupplier(@PathVariable Long id){				
		Optional<VehiclesSupplier> vehiclesSupplier = vehiclesSupplierRepository.findById(id);
		
		if(vehiclesSupplier.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		vehiclesSuppliersService.deleteVehiclesSupplier(id);
		return ResponseEntity.ok().build();		
		
	}
}

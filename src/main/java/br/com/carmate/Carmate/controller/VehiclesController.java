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

import br.com.carmate.Carmate.model.Vehicle;
import br.com.carmate.Carmate.repository.VehicleRepository;
import br.com.carmate.Carmate.service.VehiclesService;

@RestController
@RequestMapping("api/vehicles")
public class VehiclesController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	private VehiclesService vehiclesService;
	
	@Autowired
	public void setSuppliersService(VehiclesService vehiclesService) {
		this.vehiclesService = vehiclesService;
	}
	
	@GetMapping
	public ResponseEntity<List<Vehicle>> listVehicles(){
		return ResponseEntity.ok().body(vehiclesService.listVehicles());
	}
	
	@PostMapping
	public ResponseEntity<?> newVehicle (@RequestBody Vehicle vehicle){		
		vehiclesService.saveVehicle(vehicle);				
		return ResponseEntity.ok().build();
	}	
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle){			
		vehiclesService.updateVehicle(id, vehicle);
		return ResponseEntity.ok().build();						
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteVehicle(@PathVariable Long id){				
		Optional<Vehicle> vehicle = vehicleRepository.findById(id);
		
		if(vehicle.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		vehiclesService.deleteSupplier(id);
		return ResponseEntity.ok().build();
				
	}
	
	
}

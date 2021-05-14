package br.com.carmate.Carmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carmate.Carmate.model.Vehicle;
import br.com.carmate.Carmate.service.VehiclesService;

@RestController
@RequestMapping("api/vehicles")
public class VehiclesController {

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
	
}

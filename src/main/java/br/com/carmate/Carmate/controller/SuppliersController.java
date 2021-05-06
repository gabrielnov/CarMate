package br.com.carmate.Carmate.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carmate.Carmate.model.Supplier;
import br.com.carmate.Carmate.repository.SupplierRepository;
import br.com.carmate.Carmate.service.SuppliersService;
import javassist.NotFoundException;

@RestController
@RequestMapping("api/suppliers")
public class SuppliersController {
	
	private SuppliersService suppliersService;
	
	@Autowired
	public void setSuppliersService(SuppliersService suppliersService) {
		this.suppliersService = suppliersService;
	}
	
	@GetMapping
	public ResponseEntity<List<Supplier>> listSuppliers() {
		return ResponseEntity.ok().body(suppliersService.listSuppliers());
						
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Supplier> findById(@PathVariable Long id) {
	
		return suppliersService.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
		
	}

	
	
}

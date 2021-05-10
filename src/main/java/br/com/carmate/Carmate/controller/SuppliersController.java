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

import br.com.carmate.Carmate.model.Supplier;
import br.com.carmate.Carmate.repository.SupplierRepository;
import br.com.carmate.Carmate.service.SuppliersService;

@RestController
@RequestMapping("api/suppliers")
public class SuppliersController {
	
	@Autowired
	private SupplierRepository supplierRepository;
		
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

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Supplier supplier){
		
		suppliersService.saveSupplier(supplier);		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> replaceSuppliers (@PathVariable Long id, @RequestBody Supplier newSupplier){
			
		suppliersService.updateSupplier(id, newSupplier);
		return ResponseEntity.ok().build();						
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteSuppliers(@PathVariable Long id){		
		
		Optional<Supplier> supplier = supplierRepository.findById(id);
		
		if(supplier.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		suppliersService.deleteSupplier(id);
		return ResponseEntity.ok().build();		
		
	}
}

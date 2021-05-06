package br.com.carmate.Carmate.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.carmate.Carmate.model.Supplier;
import br.com.carmate.Carmate.repository.SupplierRepository;
import br.com.carmate.Carmate.service.SuppliersService;
import javassist.NotFoundException;

@RestController
@RequestMapping("api/suppliers")
public class SuppliersController {
	
	@Autowired
	private SupplierRepository repository;
		
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
		
		supplier = suppliersService.saveSupplier(supplier);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(supplier.getId()).toUri();
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<?> replaceSuppliers (@PathVariable Long id, @RequestBody Supplier newSupplier){
	
		Supplier updatedSupplier = repository.findById(id)
				.map(supplier -> {
					supplier.setAdress(newSupplier.getAdress());
					supplier.setCompanyName(newSupplier.getCompanyName());
					supplier.setPhoneNumber(newSupplier.getPhoneNumber());
					return repository.save(supplier);
				})
				.orElseGet(() -> {
					newSupplier.setId(id);
					return repository.save(newSupplier);
				});
		
		
		return ResponseEntity.ok().build();
				
	}
	
}

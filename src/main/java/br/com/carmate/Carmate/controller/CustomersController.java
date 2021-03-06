package br.com.carmate.Carmate.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

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

import br.com.carmate.Carmate.model.Customer;
import br.com.carmate.Carmate.repository.CustomerRepository;
import br.com.carmate.Carmate.service.CustomersService;

@RestController
@RequestMapping("api/customers")
public class CustomersController {
	
	@Autowired
	private CustomerRepository customerRepository;
		
	private CustomersService customersService;
	
	@Autowired
	public void setCustomersService(CustomersService customersService) {
		this.customersService = customersService;
	}
		
	@GetMapping
	public ResponseEntity<List<Customer>> listCustomers(){		
		return ResponseEntity.ok().body(customersService.listCustomers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Customer> findCustomerById(@PathVariable Long id) {		
		return customersService.findById(id)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<?> newCustomer(@Valid @RequestBody Customer customer){		
		customersService.saveCustomer(customer);		
		return ResponseEntity.noContent().build();	
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody Customer customer){			
		customersService.updateCustomer(id, customer);
		return ResponseEntity.noContent().build();				
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deleteCustomer(@PathVariable Long id){				
		Optional<Customer> supplier = customerRepository.findById(id);
		
		if(supplier.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		customersService.deleteSupplier(id);
		
		return ResponseEntity.ok().build();
				
	}
}

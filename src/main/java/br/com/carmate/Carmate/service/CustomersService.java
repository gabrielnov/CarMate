package br.com.carmate.Carmate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.carmate.Carmate.model.Customer;
import br.com.carmate.Carmate.model.Supplier;
import br.com.carmate.Carmate.repository.CustomerRepository;

@Service
public class CustomersService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> listCustomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Customer> findById(@PathVariable Long id) {
	
		Optional<Customer> customer = customerRepository.findById(id);
		
		return customer;
	}

	public Customer saveSupplier(Customer customer) {
		return customerRepository.save(customer);
		
	}
}

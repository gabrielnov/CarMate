package br.com.carmate.Carmate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carmate.Carmate.model.Customer;
import br.com.carmate.Carmate.repository.CustomerRepository;

@Service
public class CustomersService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> listCustomers() {
		return customerRepository.findAll();
	}

}

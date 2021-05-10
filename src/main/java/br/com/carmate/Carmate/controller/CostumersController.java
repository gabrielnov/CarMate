package br.com.carmate.Carmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.carmate.Carmate.model.Customer;
import br.com.carmate.Carmate.service.CustomersService;

@RestController
@RequestMapping("api/customers")
public class CostumersController {
	
	private CustomersService customersService;
	
	@Autowired
	public void setCustomersService(CustomersService customersService) {
		this.customersService = customersService;
	}
	
	
	@GetMapping
	public ResponseEntity<List<Customer>> listCustomers(){
		return ResponseEntity.ok().body(customersService.listCustomers());
	}
}

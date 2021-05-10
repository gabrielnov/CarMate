package br.com.carmate.Carmate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carmate.Carmate.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	}

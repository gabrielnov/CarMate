package br.com.carmate.Carmate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carmate.Carmate.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	}

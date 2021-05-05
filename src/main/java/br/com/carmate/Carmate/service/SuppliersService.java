package br.com.carmate.Carmate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carmate.Carmate.model.Supplier;
import br.com.carmate.Carmate.repository.SupplierRepository;

@Service
public class SuppliersService {

	@Autowired
	SupplierRepository repository;

	public List<Supplier> listSuppliers() {
		return repository.findAll();
		
		
	}

	public Optional<Supplier> findById(Long id) {
		
		//TODO add Exception in case of null supplier
		
		Optional<Supplier> supplier = repository.findById(id);
		
		return supplier;
	}
}

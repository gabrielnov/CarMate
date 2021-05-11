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
	SupplierRepository supplierRepository;

	public List<Supplier> listSuppliers() {
		return supplierRepository.findAll();		
	}

	public Optional<Supplier> findById(Long id) {		
		Optional<Supplier> supplier = supplierRepository.findById(id);
					
		return supplier;
		
	}
	
	public Supplier saveSupplier(Supplier supplier) {			
		return supplierRepository.save(supplier);
	}
	
	public void deleteSupplier(Long id) {			
		supplierRepository.deleteById(id);		
		
	}

	public Supplier updateSupplier(Long id, Supplier newSupplier) {		
		newSupplier.setId(id);
		
		return supplierRepository.save(newSupplier);

	}
}
	

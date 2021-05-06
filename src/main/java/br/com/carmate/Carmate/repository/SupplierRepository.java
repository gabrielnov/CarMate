package br.com.carmate.Carmate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carmate.Carmate.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{

	
}

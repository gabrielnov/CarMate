package br.com.carmate.Carmate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carmate.Carmate.model.Provider;
import br.com.carmate.Carmate.repository.ProviderRepository;

@Service
public class ProvidersService {

	@Autowired
	ProviderRepository repository;

	public List<Provider> listProviders() {
		return repository.findAll();
		
		
	}
}

package br.com.carmate.Carmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carmate.Carmate.model.Provider;
import br.com.carmate.Carmate.repository.ProviderRepository;

@RestController
@RequestMapping("api/provider")
public class ProviderController {
	
	@Autowired
	ProviderRepository repository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Provider> getProviders() {
		
		List<Provider> providers = repository.findAll();
		
		return providers;
				
	}

	
}

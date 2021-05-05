package br.com.carmate.Carmate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carmate.Carmate.model.Provider;
import br.com.carmate.Carmate.repository.ProviderRepository;
import br.com.carmate.Carmate.service.ProvidersService;

@RestController
@RequestMapping("api/provider")
public class ProvidersController {
	
	private ProvidersService providersService;
	
	@Autowired
	public void setProvidersService(ProvidersService providersService) {
		this.providersService = providersService;
	}
	
	@GetMapping
	public ResponseEntity<List<Provider>> listProviders() {
		return ResponseEntity.ok().body(providersService.listProviders());
						
	}

	
}

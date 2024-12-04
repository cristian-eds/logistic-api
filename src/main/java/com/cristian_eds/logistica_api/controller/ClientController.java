package com.cristian_eds.logistica_api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian_eds.logistica_api.domain.model.Client;
import com.cristian_eds.logistica_api.repository.ClientRepository;


@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	@GetMapping("/test")
	public List<Client> listClients() {
		var client1 = new Client(1l,"joao","joao@emial.com","13213232");
		var clients = Arrays.asList(client1);
		return clients;
	}
	
	@GetMapping()
	public List<Client> getClients() {
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable Long id) {
		Optional<Client> client = repository.findById(id);
		if(client.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(client.get());
	}

}

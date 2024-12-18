package com.cristian_eds.logistica_api.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cristian_eds.logistica_api.domain.model.Client;
import com.cristian_eds.logistica_api.domain.service.ClientService;
import com.cristian_eds.logistica_api.repository.ClientRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	@Autowired
	private ClientService service;
	
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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Client> addNewClient(@Valid @RequestBody Client client){
		return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(service.save(client));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> updateClient(@Valid @RequestBody Client client, @PathVariable Long id) {
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		client.setId(id);
		return ResponseEntity.ok(service.save(client));
	}

	
	@DeleteMapping("/{clientId}")
	public ResponseEntity<Void> deleteClient(@PathVariable Long clientId) {
		if(!repository.existsById(clientId)) {
			return ResponseEntity.notFound().build();
		}
		service.delete(clientId);
		return ResponseEntity.noContent().build();
	}
}

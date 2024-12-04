package com.cristian_eds.logistica_api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian_eds.logistica_api.domain.model.Client;
import com.cristian_eds.logistica_api.repository.ClientRepository;

@RestController
public class ClientController {
	
	@Autowired
	private ClientRepository repository;
	
	@GetMapping("/clients")
	public List<Client> listClients() {
		var client1 = new Client(1l,"joao","joao@emial.com","13213232");
		var clients = Arrays.asList(client1);
		return clients;
	}
	
	@GetMapping
	public List<Client> getClients() {
		return repository.findAll();
	}
}

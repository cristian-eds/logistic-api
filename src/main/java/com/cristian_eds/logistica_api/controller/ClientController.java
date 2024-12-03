package com.cristian_eds.logistica_api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cristian_eds.logistica_api.domain.model.Client;

@RestController
public class ClientController {
	
	@GetMapping("/clients")
	public List<Client> listClients() {
		var client1 = new Client(1l,"joao","joao@emial.com","13213232");
		System.err.println(client1);
		var clients = Arrays.asList(client1);
		return clients;
	}
}

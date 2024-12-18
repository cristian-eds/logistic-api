package com.cristian_eds.logistica_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristian_eds.logistica_api.domain.exception.DomainException;
import com.cristian_eds.logistica_api.domain.model.Client;
import com.cristian_eds.logistica_api.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	@Transactional
	public Client save(Client client) {
		
		boolean emailAlreadyExists = repository.findByEmail(client.getEmail())
				.stream()
				.anyMatch(clientExisting -> !clientExisting.equals(client));
		
		if(emailAlreadyExists) {
			throw new DomainException("Email already exists!");
		}
		return repository.save(client);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	

}

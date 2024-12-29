package com.cristian_eds.logistica_api.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristian_eds.logistica_api.domain.model.Client;
import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.domain.model.DeliveryStatus;
import com.cristian_eds.logistica_api.repository.DeliveryRepository;

@Service
public class RegistrationDeliveryService {
	
	@Autowired
	private DeliveryRepository repository;
	
	@Autowired
	private ClientService clientService;
	
	@Transactional
	public Delivery register(Delivery delivery) {
		
		Client client = clientService.findClient(delivery.getClient().getId());
		delivery.setClient(client);
		delivery.setStatus(DeliveryStatus.PENDING);
		delivery.setOrderDate(OffsetDateTime.now());
		System.out.println(delivery.getAddressee().getAdditionalInformation());
		return repository.save(delivery);
	}
	

}

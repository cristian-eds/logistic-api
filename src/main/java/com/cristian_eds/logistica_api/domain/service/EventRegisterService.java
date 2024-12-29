package com.cristian_eds.logistica_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.domain.model.Event;


@Service
public class EventRegisterService {
	
	@Autowired
	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public Event register(Long deliveryId, String description) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		return delivery.addEvent(description);
	}
}

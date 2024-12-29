package com.cristian_eds.logistica_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian_eds.logistica_api.domain.exception.EntityNotFoundException;
import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.repository.DeliveryRepository;

@Service
public class FindDeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	public Delivery find(Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new EntityNotFoundException("Delivery not found"));
		
	}
}

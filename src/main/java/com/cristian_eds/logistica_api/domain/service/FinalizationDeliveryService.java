package com.cristian_eds.logistica_api.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.repository.DeliveryRepository;

@Service
public class FinalizationDeliveryService {
	
	@Autowired
	private FindDeliveryService findDeliveryService;
	
	@Autowired
	private DeliveryRepository deliveryRepository;

	@Transactional
	public void finalize(long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		
		delivery.finalize();
		
		deliveryRepository.save(delivery);
		
	}
}

package com.cristian_eds.logistica_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.domain.service.RegistrationDeliveryService;
import com.cristian_eds.logistica_api.repository.DeliveryRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	@Autowired
	private RegistrationDeliveryService registrationDeliveryService;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery register(@Valid @RequestBody Delivery delivery) {
		return registrationDeliveryService.register(delivery);
	}
	
	@GetMapping
	public List<Delivery> listAll() {
		return deliveryRepository.findAll();
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<Delivery> findById(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}

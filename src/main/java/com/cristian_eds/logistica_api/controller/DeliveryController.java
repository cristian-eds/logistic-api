package com.cristian_eds.logistica_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.domain.service.RegistrationDeliveryService;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	@Autowired
	private RegistrationDeliveryService registrationDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery register(@RequestBody Delivery delivery) {
		return registrationDeliveryService.register(delivery);
	}
}

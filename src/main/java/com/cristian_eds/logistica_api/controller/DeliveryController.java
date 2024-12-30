package com.cristian_eds.logistica_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cristian_eds.logistica_api.assembler.DeliveryAssembler;
import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.domain.service.FinalizationDeliveryService;
import com.cristian_eds.logistica_api.domain.service.RegistrationDeliveryService;
import com.cristian_eds.logistica_api.model.DeliveryResponse;
import com.cristian_eds.logistica_api.model.request.DeliveryRequest;
import com.cristian_eds.logistica_api.repository.DeliveryRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	@Autowired
	private RegistrationDeliveryService registrationDeliveryService;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private DeliveryAssembler deliveryAssembler;
	
	@Autowired
	private FinalizationDeliveryService finalizationDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryResponse register(@Valid @RequestBody DeliveryRequest deliveryRequest) {
		Delivery newDelivery = deliveryAssembler.toEntity(deliveryRequest);
		Delivery deliveryRegistered = registrationDeliveryService.register(newDelivery);
		return deliveryAssembler.toModel(deliveryRegistered);
	}
	
	@GetMapping
	public List<DeliveryResponse> listAll() {
		return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryResponse> findById(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId).map(
				delivery -> ResponseEntity.ok(deliveryAssembler.toModel(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{deliveryId}/finalization")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalize(@PathVariable Long deliveryId) {
		finalizationDeliveryService.finalize(deliveryId);
	}
}

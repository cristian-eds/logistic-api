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
import com.cristian_eds.logistica_api.model.AddresseeResponse;
import com.cristian_eds.logistica_api.model.DeliveryResponse;
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
	public ResponseEntity<DeliveryResponse> findById(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId).map(
				delivery -> {
					DeliveryResponse deliveryResponse = new DeliveryResponse();
					deliveryResponse.setId(delivery.getId());
					deliveryResponse.setClientName(delivery.getClient().getName());
					deliveryResponse.setAddressee(new AddresseeResponse());
					deliveryResponse.getAddressee().setAdditionalInformation(delivery.getAddressee().getAdditionalInformation());
					deliveryResponse.getAddressee().setDistrict(delivery.getAddressee().getDistrict());
					deliveryResponse.getAddressee().setName(delivery.getAddressee().getName());
					deliveryResponse.getAddressee().setNumber(delivery.getAddressee().getNumber());
					deliveryResponse.getAddressee().setStreet(delivery.getAddressee().getStreet());
					deliveryResponse.setCompletionDate(delivery.getCompletionDate());
					deliveryResponse.setOrderDate(delivery.getOrderDate());
					deliveryResponse.setTax(delivery.getTax());
					deliveryResponse.setStatus(delivery.getStatus());
					return ResponseEntity.ok(deliveryResponse);
				})
				.orElse(ResponseEntity.notFound().build());
	}
}

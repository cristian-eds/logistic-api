package com.cristian_eds.logistica_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cristian_eds.logistica_api.assembler.EventAssembler;
import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.domain.model.Event;
import com.cristian_eds.logistica_api.domain.service.EventRegisterService;
import com.cristian_eds.logistica_api.domain.service.FindDeliveryService;
import com.cristian_eds.logistica_api.model.EventResponse;
import com.cristian_eds.logistica_api.model.request.EventRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/deliveries/{deliveryId}/events")
public class EventController {

	@Autowired
	private EventRegisterService eventRegisterService;
	
	@Autowired
	private EventAssembler eventAssembler;
	
	@Autowired
	private FindDeliveryService findDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EventResponse register(@PathVariable Long deliveryId, @Valid @RequestBody EventRequest eventRequest) {
		Event eventRegistered = eventRegisterService.register(deliveryId, eventRequest.getDescription());
		return eventAssembler.toResponse(eventRegistered);
	}
	
	@GetMapping
	public List<EventResponse> list(@PathVariable Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		return eventAssembler.toCollection(delivery.getEvents());
	}
	
}

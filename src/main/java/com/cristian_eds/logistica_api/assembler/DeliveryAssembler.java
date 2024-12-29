package com.cristian_eds.logistica_api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristian_eds.logistica_api.domain.model.Delivery;
import com.cristian_eds.logistica_api.model.DeliveryResponse;
import com.cristian_eds.logistica_api.model.request.DeliveryRequest;

@Component
public class DeliveryAssembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public DeliveryResponse toModel(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryResponse.class);
	}
	
	public List<DeliveryResponse> toCollectionModel(List<Delivery> deliveries) {
		return deliveries.stream().map(this::toModel).toList();
	}
	
	public Delivery toEntity(DeliveryRequest deliveryRequest) {
		return modelMapper.map(deliveryRequest, Delivery.class);
	}
}

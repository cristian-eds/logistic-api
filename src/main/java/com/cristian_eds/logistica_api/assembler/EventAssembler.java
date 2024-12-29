package com.cristian_eds.logistica_api.assembler;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cristian_eds.logistica_api.domain.model.Event;
import com.cristian_eds.logistica_api.model.EventResponse;

@Component
public class EventAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public EventResponse toResponse(Event event) {
		return modelMapper.map(event, EventResponse.class);
	}
	
	public List<EventResponse> toCollection(List<Event> events) {
		return events.stream().map(this::toResponse).toList();
	}
	
}

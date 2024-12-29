package com.cristian_eds.logistica_api.model.request;

import jakarta.validation.constraints.NotBlank;

public class EventRequest {
	
	@NotBlank
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}

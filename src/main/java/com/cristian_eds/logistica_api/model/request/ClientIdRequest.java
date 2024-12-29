package com.cristian_eds.logistica_api.model.request;

import jakarta.validation.constraints.NotNull;

public class ClientIdRequest {
	
	@NotNull
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

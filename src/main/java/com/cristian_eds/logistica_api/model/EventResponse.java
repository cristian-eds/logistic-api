package com.cristian_eds.logistica_api.model;

import java.time.OffsetDateTime;

public class EventResponse {
	
	private Long id;
	private String description;
	private OffsetDateTime registrationDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public OffsetDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(OffsetDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
}

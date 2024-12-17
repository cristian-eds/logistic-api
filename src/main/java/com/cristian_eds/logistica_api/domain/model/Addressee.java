package com.cristian_eds.logistica_api.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Addressee {
	
	@Column(name = "addressee_name")
	private String name;
	
	@Column(name = "addressee_street")
	private String street;
	
	@Column(name = "addressee_number")
	private String number;
	
	@Column(name = "addressee_district")
	private String district;
	
	@Column(name = "addressee_additional_information")
	private String additionalInformation;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	
	
	
}

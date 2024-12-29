package com.cristian_eds.logistica_api.model.request;

import java.math.BigDecimal;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class DeliveryRequest {
	
	@Valid
	@NotNull
	private ClientIdRequest client;
	
	@Valid
	@NotNull
	private AddresseeRequest addressee;
	
	private BigDecimal tax;

	public ClientIdRequest getClient() {
		return client;
	}

	public void setClient(ClientIdRequest client) {
		this.client = client;
	}

	public AddresseeRequest getAddressee() {
		return addressee;
	}

	public void setAddressee(AddresseeRequest addressee) {
		this.addressee = addressee;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	
}

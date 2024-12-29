package com.cristian_eds.logistica_api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.cristian_eds.logistica_api.domain.model.DeliveryStatus;

public class DeliveryResponse {
	
	private Long id;
	private ShortClientResponse client;
	private AddresseeResponse addressee;
	private BigDecimal tax;
	private DeliveryStatus status;
	private OffsetDateTime orderDate;
	private OffsetDateTime completionDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ShortClientResponse getClient() {
		return client;
	}
	public void setClient(ShortClientResponse client) {
		this.client = client;
	}
	public AddresseeResponse getAddressee() {
		return addressee;
	}
	public void setAddressee(AddresseeResponse addressee) {
		this.addressee = addressee;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	public DeliveryStatus getStatus() {
		return status;
	}
	public void setStatus(DeliveryStatus status) {
		this.status = status;
	}
	public OffsetDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(OffsetDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public OffsetDateTime getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(OffsetDateTime completionDate) {
		this.completionDate = completionDate;
	}
	
}

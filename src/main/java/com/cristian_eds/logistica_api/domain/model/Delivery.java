package com.cristian_eds.logistica_api.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.cristian_eds.logistica_api.domain.model.validations.ValidationGroups;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;


@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Valid
	@ManyToOne
	@ConvertGroup(from = Default.class, to = ValidationGroups.ClientId.class)
	private Client client;
	
	@Valid
	@Embedded
	@NotNull
	private Addressee addressee;
	
	@NotNull
	private BigDecimal tax;
	
	@JsonProperty(access = Access.READ_ONLY)
	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime orderDate;
	
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime completionDate;
	
	public Delivery() {
		super();
	}

	public Delivery(Long id, Client client, Addressee addressee, BigDecimal tax, DeliveryStatus status,
			LocalDateTime orderDate, LocalDateTime completionDate) {
		super();
		this.id = id;
		this.client = client;
		this.addressee = addressee;
		this.tax = tax;
		this.status = status;
		this.orderDate = orderDate;
		this.completionDate = completionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Addressee getAddressee() {
		return addressee;
	}

	public void setAddressee(Addressee addressee) {
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

	public LocalDateTime getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDateTime getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(LocalDateTime completionDate) {
		this.completionDate = completionDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Delivery other = (Delivery) obj;
		return Objects.equals(id, other.id);
	}
	
}

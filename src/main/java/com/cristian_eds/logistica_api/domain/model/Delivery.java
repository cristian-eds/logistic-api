package com.cristian_eds.logistica_api.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.cristian_eds.logistica_api.domain.exception.DomainException;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Delivery {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Client client;

	@Embedded
	private Addressee addressee;

	private BigDecimal tax;

	@Enumerated(EnumType.STRING)
	private DeliveryStatus status;
	
	private OffsetDateTime orderDate;

	private OffsetDateTime completionDate;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Event> events = new ArrayList<>();
	
	public Delivery() {
		super();
	}

	public Delivery(Long id, Client client, Addressee addressee, BigDecimal tax, DeliveryStatus status,
			OffsetDateTime orderDate, OffsetDateTime completionDate) {
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

	
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
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

	public Event addEvent(String description) {
		Event event = new Event();
		event.setDescription(description);
		event.setRegistrationDate(OffsetDateTime.now());
		event.setDelivery(this);
		
		this.getEvents().add(event);
		
		return event;
	}
	
	public void finalize() {
		if (!canBeFinished()) {
			throw new DomainException("Delivery cannot be completed");
		}
		setStatus(DeliveryStatus.FINALIZED);
		setCompletionDate(OffsetDateTime.now());
	}
	
	public boolean canBeFinished() {
		return DeliveryStatus.PENDING.equals(getStatus());
	}

	
}

package com.cristian_eds.logistica_api.domain.exception;

public class EntityNotFoundException extends DomainException {


	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String message) {
		super(message);
	}

}

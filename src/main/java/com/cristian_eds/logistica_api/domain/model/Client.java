package com.cristian_eds.logistica_api.domain.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;


@Data
@JsonSerialize
public class Client {

	private Long id;
	
	private String name;
	
	private String email;
	
	private String telefone;
	
	public Client(long id, String name, String email, String telefone) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telefone = telefone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getId() {
		return id;
	}

	

}

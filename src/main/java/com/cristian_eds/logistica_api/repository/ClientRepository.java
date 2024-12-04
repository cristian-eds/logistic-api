package com.cristian_eds.logistica_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cristian_eds.logistica_api.domain.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{

}

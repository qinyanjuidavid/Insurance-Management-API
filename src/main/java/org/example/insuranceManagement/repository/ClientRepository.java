package org.example.insuranceManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.example.insuranceManagement.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Long> {
    
    Optional<Client> findByClientEmail(String clientEmail);
}

package com.royaldrop.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.royaldrop.main.dao.DeliveryAgent;

@Repository
public interface DeliveryAgentRepository extends JpaRepository<DeliveryAgent, Long> {
}
package com.royaldrop.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.royaldrop.main.dao.Deliveries;

@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries, Long> {

	@Query("SELECT d FROM Deliveries d WHERE d.deliveryAgent.id = :agentId")
	List<Deliveries> findByDeliveryAgentId(@Param("agentId") Long agentId);
}
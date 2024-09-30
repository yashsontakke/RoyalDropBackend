package com.royaldrop.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.royaldrop.main.dao.Deliveries;

@Repository
public interface DeliveriesRepository extends JpaRepository<Deliveries, Long> {
}
package com.royaldrop.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royaldrop.main.dao.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
}

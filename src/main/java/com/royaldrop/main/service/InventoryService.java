package com.royaldrop.main.service;

import java.util.List;

import com.royaldrop.main.dao.Inventory;

public interface InventoryService {
    Inventory createInventory(Inventory inventory);
    List<Inventory> getAllInventories();
    // Add other necessary methods as needed
	Inventory findById(Long id);
}

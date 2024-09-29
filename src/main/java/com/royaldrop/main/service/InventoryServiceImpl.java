package com.royaldrop.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royaldrop.main.dao.Inventory;
import com.royaldrop.main.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory createInventory(Inventory inventory) {

    	try {
            return inventoryRepository.save(inventory);
        } catch (Exception e) {
            System.err.println("Error saving inventory: " + e.getMessage());
            throw e; // or handle it appropriately
        }    }

    @Override
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }
    
    // Implement other methods as needed
}
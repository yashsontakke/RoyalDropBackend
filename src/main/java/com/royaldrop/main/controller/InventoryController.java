package com.royaldrop.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royaldrop.main.dao.Inventory;
import com.royaldrop.main.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

//    @Autowired
	 private final InventoryService inventoryService;

	    @Autowired
	    public InventoryController(InventoryService inventoryService) {
	        this.inventoryService = inventoryService;
	    }

	    @PostMapping("/create")
	    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
	        try {
	            Inventory savedInventory = inventoryService.createInventory(inventory);
	            return new ResponseEntity<>(savedInventory, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<Inventory>> getAllInventories() {
	        List<Inventory> inventories = inventoryService.getAllInventories();
	        return new ResponseEntity<>(inventories, HttpStatus.OK);
	    }
}

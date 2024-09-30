package com.royaldrop.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royaldrop.main.dao.Inventory;
import com.royaldrop.main.dto.DeliveryRequestDTO;
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

	    @GetMapping("/{id}")
	    public ResponseEntity<Inventory> getProductById(@PathVariable("id") Long id) {

	        try {
	            // Fetch product from the repository
	            Inventory product = inventoryService.findById(id);
	            
	            
	            if (product != null) {
	                return new ResponseEntity<>(product, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            // Handle exceptions appropriately
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    @PostMapping("/out-for-delivery")
	    public ResponseEntity<?> updateProductForDelivery(@RequestBody DeliveryRequestDTO deliveryRequest) {
	        try {
	            // Logic to handle product delivery and reduce quantity
	            inventoryService.reduceProductQuantity(deliveryRequest.getProductId(), deliveryRequest.getQuantity());

	            return new ResponseEntity<>("Product delivery status updated", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error processing delivery", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PostMapping("/returned-to-warehouse")
	    public ResponseEntity<?> updateProductForReturn(@RequestBody DeliveryRequestDTO deliveryRequest) {
	        try {
	            // Logic to handle product return and increase quantity
	            inventoryService.increaseProductQuantity(deliveryRequest.getProductId(), deliveryRequest.getQuantity());

	            return new ResponseEntity<>("Product return status updated", HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>("Error processing return", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

}

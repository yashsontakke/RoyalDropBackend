package com.royaldrop.main.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royaldrop.main.dao.Deliveries;
import com.royaldrop.main.dto.DeliveriesDTO;

import com.royaldrop.main.service.DeliveriesService;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveriesController {

	   @Autowired
	    private DeliveriesService deliveriesService;
	   
//	   private DeliveryAgentService deliveryAgentService;

	    @PostMapping("/add")
	    public ResponseEntity<DeliveriesDTO> addDelivery(@RequestBody Deliveries delivery) {
	        return ResponseEntity.ok(deliveriesService.saveDelivery(delivery));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DeliveriesDTO> getDeliveryById(@PathVariable Long id) {
	        DeliveriesDTO delivery = deliveriesService.getDeliveryById(id);
	        return (delivery != null) ? ResponseEntity.ok(delivery) : ResponseEntity.notFound().build();
	    }


	    @GetMapping("/agent/{agentId}")
	    public ResponseEntity<List<DeliveriesDTO>> getDeliveriesByAgentId(@PathVariable("agentId") Long agentId) {
	        List<DeliveriesDTO> deliveries = deliveriesService.getDeliveriesByAgentId(agentId);
	        if (deliveries != null && !deliveries.isEmpty()) {
	            return new ResponseEntity<>(deliveries, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @GetMapping("/agent/{agentId}/today-pending")
	    public ResponseEntity<List<Deliveries>> getTodaysPendingDeliveries(@PathVariable Long agentId) {
	    	System.out.print("coming");
	        List<Deliveries> deliveries = deliveriesService.getTodaysPendingDeliveries(agentId);
	        return ResponseEntity.ok(deliveries);
	    }
	    
	    @GetMapping("/agent/{agentId}/other-pending")
	    public ResponseEntity<List<Deliveries>> getPendingDeliveriesNotToday(@PathVariable Long agentId) {
	        List<Deliveries> deliveries = deliveriesService.getPendingDeliveriesNotToday(agentId);
	        return ResponseEntity.ok(deliveries);
	    }
	    
	    @GetMapping("/agent/{agentId}/delayed")
	    public ResponseEntity<List<Deliveries>> getDelayedDeliveries(@PathVariable Long agentId) {
	        List<Deliveries> deliveries = deliveriesService.getDelayedDeliveries(agentId);
	        return ResponseEntity.ok(deliveries);
	    }
}
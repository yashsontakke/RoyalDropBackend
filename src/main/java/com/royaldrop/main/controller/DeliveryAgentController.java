package com.royaldrop.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royaldrop.main.dao.Deliveries;
import com.royaldrop.main.dto.DeliveriesDTO;
import com.royaldrop.main.dto.DeliveryAgentDTO;
import com.royaldrop.main.repository.DeliveriesRepository;
import com.royaldrop.main.service.DeliveriesService;
import com.royaldrop.main.service.DeliveryAgentService;

@RestController
@RequestMapping("/api/delivery-agents")
public class DeliveryAgentController {

	 @Autowired
	    private DeliveriesRepository deliveriesRepository;
	 @Autowired
	    private DeliveriesService deliveriesService;

	 @Autowired
	 private DeliveryAgentService deliveryAgentService;
	    // Convert Deliveries to DeliveriesDTO
	    private DeliveriesDTO convertToDTO(Deliveries delivery) {
	        return new DeliveriesDTO(
	            delivery.getId(),
	            delivery.getCustomerName(),
	            delivery.getExpectedDateOfDelivery().toString(),
	            delivery.getStatus(),
	            delivery.getCustomerAddress(),
	            delivery.getCustomerMobileNumber(),
	            delivery.getDeliveryAgent().getDeliveryAgentId(),
	            delivery.getProductId()
	        );
	    }
	    
	    @GetMapping("/{id}")
	    public ResponseEntity<DeliveryAgentDTO> getDeliveryAgentById(@PathVariable Long id) {
	        // Fetch the DeliveryAgentDTO using the service layer
	        DeliveryAgentDTO agent = deliveryAgentService.getDeliveryAgentById(id);	        
	        
	        // Check if the agent exists
	        if (agent != null) {	     
	            // Return the agent data with an OK status
	            return ResponseEntity.ok(agent);
	        } else {
	            // If agent not found, return 404 Not Found
	            return ResponseEntity.notFound().build();
	        }
	    }

	    public DeliveriesDTO saveDelivery(Deliveries delivery) {
	        Deliveries savedDelivery = deliveriesRepository.save(delivery);
	        return convertToDTO(savedDelivery);
	    }

//	    public List<DeliveriesDTO> getDeliveriesByAgent(DeliveryAgent agent) {
//	        return deliveriesRepository.findByDeliveryAgent(agent).stream()
//	                .map(this::convertToDTO)
//	                .collect(Collectors.toList());
//	    }

	    public DeliveriesDTO getDeliveryById(Long id) {
	        return deliveriesRepository.findById(id)
	                .map(this::convertToDTO)
	                .orElse(null);
	    }
	    
	    @PutMapping("/deliveries/{deliveryId}/status")
	    public ResponseEntity<Deliveries> updateDeliveryStatus(@PathVariable Long deliveryId) {
	    	System.out.print("abc");
	        Deliveries updatedDelivery = deliveriesService.updateDeliveryStatus(deliveryId);
	        return ResponseEntity.ok(updatedDelivery);
	    }
}
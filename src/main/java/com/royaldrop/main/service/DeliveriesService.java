package com.royaldrop.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royaldrop.main.dao.Deliveries;
import com.royaldrop.main.dto.DeliveriesDTO;
import com.royaldrop.main.repository.DeliveriesRepository;

@Service
public class DeliveriesService {
	 @Autowired
	    private DeliveriesRepository deliveriesRepository;

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
	    

	    public List<DeliveriesDTO> getDeliveriesByAgentId(Long deliveryAgentId) {
	        List<Deliveries> deliveries = deliveriesRepository.findByDeliveryAgentId(deliveryAgentId);

	        // Convert Delivery entities to DeliveryDTOs
	        List<DeliveriesDTO> deliveryDTOs = deliveries.stream().map(delivery -> 
	            new DeliveriesDTO(
	            		delivery.getId(),
	    	            delivery.getCustomerName(),
	    	            delivery.getExpectedDateOfDelivery().toString(),
	    	            delivery.getStatus(),
	    	            delivery.getCustomerAddress(),
	    	            delivery.getCustomerMobileNumber(),
	    	            delivery.getDeliveryAgent().getDeliveryAgentId(),
	    	            delivery.getProductId()  // Fetch product name from the associated Inventory entity
	            )
	        ).collect(Collectors.toList());

	        return deliveryDTOs;
	    }
}

package com.royaldrop.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveriesDTO {
    private Long deliveryId;
    private String customerName;
    private String expectedDateOfDelivery;
    private String status;
    private String customerAddress;
    private String customerMobileNumber;

    private Long deliveryAgentId; // Reference to DeliveryAgent
    private Long productId ;

    // Constructors
    
    
}

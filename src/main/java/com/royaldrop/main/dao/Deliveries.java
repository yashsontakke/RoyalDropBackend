package com.royaldrop.main.dao;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "deliveries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Deliveries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    private LocalDate expectedDateOfDelivery;

    private String status;

    private String customerAddress;

    private String customerMobileNumber;
    
    private Long productId;

    // Many deliveries belong to one delivery agent
    @ManyToOne
    @JoinColumn(name = "delivery_agent_id")
    private DeliveryAgent deliveryAgent;
    

    public Deliveries(String customerName, LocalDate expectedDateOfDelivery, String customerAddress, String customerMobileNumber, DeliveryAgent deliveryAgent , Long productId ) {
        this.customerName = customerName;
        this.expectedDateOfDelivery = expectedDateOfDelivery;
        this.customerAddress = customerAddress;
        this.customerMobileNumber = customerMobileNumber;
        this.deliveryAgent = deliveryAgent;
        
        // Set status to "Pending" if expected date exceeds the current date
        if (expectedDateOfDelivery.isAfter(LocalDate.now())) {
            this.status = "Delayed";
        } else {
            this.status = "Pending";
        }
        this.productId = productId ;
    }

}
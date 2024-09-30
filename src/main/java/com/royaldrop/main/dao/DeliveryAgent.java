package com.royaldrop.main.dao;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "deliveryAgent")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryAgent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deliveryAgentId;

    private String agentName;

    private String agentMobileNumber;

    // One DeliveryAgent can have many deliveries
    @OneToMany(mappedBy = "deliveryAgent", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Deliveries> deliveries;
    
    public DeliveryAgent(String agentName, String agentMobileNumber) {
        this.agentName = agentName;
        this.agentMobileNumber = agentMobileNumber;
    }
}
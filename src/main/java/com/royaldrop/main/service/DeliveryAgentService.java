package com.royaldrop.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royaldrop.main.dao.DeliveryAgent;
import com.royaldrop.main.repository.DeliveryAgentRepository;

@Service
public class DeliveryAgentService {

    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;

    public List<DeliveryAgent> getAllDeliveryAgents() {
        return deliveryAgentRepository.findAll();
    }

    public Optional<DeliveryAgent> getDeliveryAgentById(Long id) {
        return deliveryAgentRepository.findById(id);
    }

    public DeliveryAgent saveDeliveryAgent(DeliveryAgent deliveryAgent) {
        return deliveryAgentRepository.save(deliveryAgent);
    }

    public void deleteDeliveryAgent(Long id) {
        deliveryAgentRepository.deleteById(id);
    }
}
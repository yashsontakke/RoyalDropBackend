package com.royaldrop.main.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royaldrop.main.dao.DeliveryAgent;
import com.royaldrop.main.dto.DeliveryAgentDTO;
import com.royaldrop.main.repository.DeliveryAgentRepository;
@Service
public class DeliveryAgentService {

    @Autowired
    private DeliveryAgentRepository deliveryAgentRepository;

    // Convert DeliveryAgent to DeliveryAgentDTO
    private DeliveryAgentDTO convertToDTO(DeliveryAgent agent) {
        return new DeliveryAgentDTO(agent.getDeliveryAgentId(), agent.getAgentName(), agent.getAgentMobileNumber());
    }

    public DeliveryAgentDTO saveDeliveryAgent(DeliveryAgent agent) {
        DeliveryAgent savedAgent = deliveryAgentRepository.save(agent);
        return convertToDTO(savedAgent);
    }

    public DeliveryAgentDTO getDeliveryAgentById(Long id) {
        return deliveryAgentRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public List<DeliveryAgentDTO> getAllDeliveryAgents() {
        return deliveryAgentRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
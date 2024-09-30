package com.royaldrop.main.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.royaldrop.main.dao.DeliveryAgent;
import com.royaldrop.main.service.DeliveryAgentService;

@RestController
@RequestMapping("/api/delivery-agent")
public class DeliveryAgentController {

    @Autowired
    private DeliveryAgentService deliveryAgentService;

    @GetMapping
    public List<DeliveryAgent> getAllAgents() {
        return deliveryAgentService.getAllDeliveryAgents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryAgent> getAgentById(@PathVariable Long id) {
        Optional<DeliveryAgent> agent = deliveryAgentService.getDeliveryAgentById(id);
        return agent.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public DeliveryAgent createAgent(@RequestBody DeliveryAgent agent) {
        return deliveryAgentService.saveDeliveryAgent(agent);
    }

    @DeleteMapping("/{id}")
    public void deleteAgent(@PathVariable Long id) {
        deliveryAgentService.deleteDeliveryAgent(id);
    }
}
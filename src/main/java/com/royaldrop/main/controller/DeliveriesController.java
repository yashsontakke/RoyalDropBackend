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

import com.royaldrop.main.dao.Deliveries;
import com.royaldrop.main.service.DeliveriesService;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveriesController {

    @Autowired
    private DeliveriesService deliveriesService;

    @GetMapping
    public List<Deliveries> getAllDeliveries() {
        return deliveriesService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Deliveries> getDeliveryById(@PathVariable Long id) {
        Optional<Deliveries> delivery = deliveriesService.getDeliveryById(id);
        return delivery.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Deliveries createDelivery(@RequestBody Deliveries delivery) {
        return deliveriesService.saveDelivery(delivery);
    }

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable Long id) {
        deliveriesService.deleteDelivery(id);
    }
}
package com.royaldrop.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royaldrop.main.dao.Deliveries;
import com.royaldrop.main.repository.DeliveriesRepository;

@Service
public class DeliveriesService {

    @Autowired
    private DeliveriesRepository deliveriesRepository;

    public List<Deliveries> getAllDeliveries() {
        return deliveriesRepository.findAll();
    }

    public Optional<Deliveries> getDeliveryById(Long id) {
        return deliveriesRepository.findById(id);
    }

    public Deliveries saveDelivery(Deliveries delivery) {
        return deliveriesRepository.save(delivery);
    }

    public void deleteDelivery(Long id) {
        deliveriesRepository.deleteById(id);
    }
}

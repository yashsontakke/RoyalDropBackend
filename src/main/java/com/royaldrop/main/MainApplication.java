package com.royaldrop.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.royaldrop.main.dao.Deliveries;
import com.royaldrop.main.dao.DeliveryAgent;
import com.royaldrop.main.repository.DeliveryAgentRepository;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
	
	@Autowired
    private DeliveryAgentRepository deliveryAgentRepository;


	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        // Insert Delivery Agent
        DeliveryAgent agent1 = new DeliveryAgent("John Doe", "1234567890");
        DeliveryAgent agent2 = new DeliveryAgent("Jane Smith", "0987654321");

        // Insert Deliveries for agent1
        Deliveries delivery1 = new Deliveries(
            "Customer A", 
            LocalDate.now().plusDays(2),  // Future date, should be "Pending"
            "123 Street, City A", 
            "9876543210", 
            agent1
        );
        
        Deliveries delivery2 = new Deliveries(
            "Customer B", 
            LocalDate.now().minusDays(1),  // Past date, should be "Delivered"
            "456 Avenue, City B", 
            "1234567891", 
            agent1
        );

        // Insert Deliveries for agent2
        Deliveries delivery3 = new Deliveries(
            "Customer C", 
            LocalDate.now().plusDays(5),  // Future date, should be "Pending"
            "789 Road, City C", 
            "5678901234", 
            agent2
        );

        // Associate deliveries with agents
        List<Deliveries> deliveriesForAgent1 = new ArrayList<>();
        deliveriesForAgent1.add(delivery1);
        deliveriesForAgent1.add(delivery2);
        agent1.setDeliveries(deliveriesForAgent1);

        List<Deliveries> deliveriesForAgent2 = new ArrayList<>();
        deliveriesForAgent2.add(delivery3);
        agent2.setDeliveries(deliveriesForAgent2);

        // Save agents along with deliveries (thanks to cascading)
        deliveryAgentRepository.save(agent1);
        deliveryAgentRepository.save(agent2);
        
        System.out.println("Dummy data inserted successfully.");
    }

}

package com.royaldrop.main.dao;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_category", nullable = false)
    private String productCategory;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "is_perishable")
    private boolean isPerishable;

    @Column(name = "is_damaged")
    private boolean isDamaged;
}

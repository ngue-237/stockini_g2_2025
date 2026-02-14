package com.logonedigital.stockini_g2_2025.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "product_stock")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductStock {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String productStockId;
    private double quantity;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    public ProductStock(double quantity, LocalDate createdAt) {
        this.quantity = quantity;
        this.createdAt = createdAt;
    }

}

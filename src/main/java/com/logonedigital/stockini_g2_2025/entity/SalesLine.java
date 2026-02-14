package com.logonedigital.stockini_g2_2025.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SalesLine {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String idSalesLine;
    private Double quantity;
    private Double unitPrice;
    private Double subtotal;
    @ManyToOne
    private Product product;
}

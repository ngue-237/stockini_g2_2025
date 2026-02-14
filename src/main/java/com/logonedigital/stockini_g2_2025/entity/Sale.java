package com.logonedigital.stockini_g2_2025.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Sale {
    @Id
    @Column(unique = true)
    private String reference;
    private Double totalHT;
    private Double totalTTC;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @OneToMany
    private List<SalesLine> salesLine;
}

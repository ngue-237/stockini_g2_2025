package com.logonedigital.stockini_g2_2025.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idProduct;
    @NotEmpty
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String slug;

    private Boolean status;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    @ManyToOne
    private Category category;
    @OneToOne
    private ProductStock productStock;

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product(String idProduct, String name, String description, Double price, String slug, Boolean status, LocalDate createdAt, LocalDate updatedAt, Category category) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.price = price;
        this.slug = slug;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.category = category;
    }


}

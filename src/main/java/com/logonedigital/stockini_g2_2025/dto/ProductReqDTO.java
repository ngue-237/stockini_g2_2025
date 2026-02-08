package com.logonedigital.stockini_g2_2025.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ProductReqDTO {

    @NotEmpty(message = "Please fill product's name")
    private String name;
    @NotEmpty(message = "Please fill product's description")
    private String description;
    @NotNull
    private Double price;

    public ProductReqDTO() {
    }

    public ProductReqDTO(String description, String name, Double price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

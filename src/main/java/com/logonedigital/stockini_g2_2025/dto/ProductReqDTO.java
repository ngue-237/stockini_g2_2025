package com.logonedigital.stockini_g2_2025.dto;

public class ProductReqDTO {

    private String name;
    private String description;
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

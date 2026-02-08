package com.logonedigital.stockini_g2_2025.dto;

public class ProductResDTO {

    private String idProduct;
    private String name;
    private String description;
    private String slug;
    private Double price;

    public ProductResDTO() {
    }

    public ProductResDTO(String idProduct, String name, String description, String slug, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.slug = slug;
        this.price = price;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
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

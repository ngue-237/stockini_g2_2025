package com.logonedigital.stockini_g2_2025.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ProductResDTO {

    private String idProduct;
    private String name;
    private String description;
    private String slug;
    private Double price;
    private Double quantity;

    public ProductResDTO(String idProduct, String name, String description, String slug, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.slug = slug;
        this.price = price;
    }

    public ProductResDTO(String idProduct, String name, String description, String slug, Double price, Double quantity) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.slug = slug;
        this.price = price;
        this.quantity = quantity;
    }


}

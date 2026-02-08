package com.logonedigital.stockini_g2_2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResDTO {

    private String idProduct;
    private String name;
    private String description;
    private String slug;
    private Double price;

    private CategoryResDto categoryResDto;

    public ProductResDTO(String idProduct, String name, String description, String slug, Double price) {
        this.idProduct = idProduct;
        this.name = name;
        this.description = description;
        this.slug = slug;
        this.price = price;
    }
}

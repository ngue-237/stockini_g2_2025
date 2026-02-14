package com.logonedigital.stockini_g2_2025.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductReqDTO {

    @NotEmpty(message = "Please fill product's name")
    private String name;
    @NotEmpty(message = "Please fill product's description")
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private Double quantity;


    public ProductReqDTO(String description, String name, Double price) {
        this.description = description;
        this.name = name;
        this.price = price;
    }
}

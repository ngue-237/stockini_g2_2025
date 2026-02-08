package com.logonedigital.stockini_g2_2025.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductReqDTO {

    @NotEmpty(message = "Please fill product's name")
    private String name;
    @NotEmpty(message = "Please fill product's description")
    private String description;
    @NotNull
    private Double price;

    @NotEmpty
    private String idCategory;


}

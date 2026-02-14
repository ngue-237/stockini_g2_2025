package com.logonedigital.stockini_g2_2025.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SaleLineReqDTO {
    @NotEmpty(message = "Product is required")
    private String idProduct;
    @NotNull(message = "Quantity is required")
    private Double quantite;
}

package com.logonedigital.stockini_g2_2025.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class SaleRequestDTO {
    @NotEmpty(message = "Customer is required")
    private  String idCustomer;
    private List<SaleLineReqDTO> saleLineReqDTOS;
}

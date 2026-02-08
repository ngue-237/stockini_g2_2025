package com.logonedigital.stockini_g2_2025.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CategoryReqDto {

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "description is required")
    private String description;


}

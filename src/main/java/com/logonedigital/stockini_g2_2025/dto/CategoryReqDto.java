package com.logonedigital.stockini_g2_2025.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;

public class CategoryReqDto {

    @NotEmpty(message = "name is required")
    private String name;

    @NotEmpty(message = "description is required")
    private String description;

    public CategoryReqDto() {
    }

    public CategoryReqDto(String name, String description) {
        this.name = name;
        this.description = description;
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
}

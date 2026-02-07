package com.logonedigital.stockini_g2_2025.dto;

import jakarta.validation.constraints.NotEmpty;

public class LocationReqDTO {
    @NotEmpty(message = "Fill this field")
    private String town;
    @NotEmpty(message = "Fill this field")
    private Integer postalCode;

    public LocationReqDTO() {
    }

    public LocationReqDTO(String town, Integer postalCode) {
        this.town = town;
        this.postalCode = postalCode;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}

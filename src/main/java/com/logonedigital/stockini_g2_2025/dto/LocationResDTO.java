package com.logonedigital.stockini_g2_2025.dto;

public class LocationResDTO {
    private String idLocation;
    private String town;
    private Integer postalCode;

    public LocationResDTO() {
    }

    public LocationResDTO(String idLocation, String town, Integer postalCode) {
        this.idLocation = idLocation;
        this.town = town;
        this.postalCode = postalCode;
    }

    public String getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(String idLocation) {
        this.idLocation = idLocation;
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

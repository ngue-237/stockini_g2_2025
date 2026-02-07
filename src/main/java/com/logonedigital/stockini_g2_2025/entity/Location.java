package com.logonedigital.stockini_g2_2025.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "locations")
public class Location {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String locationId;
    private String town;
    private Integer postalCode;
    private Boolean status;

    private LocalDate createdAt;

    private LocalDate updatedAt;

    public Location() {
    }

    public Location(Integer postalCode, String town) {
        this.postalCode = postalCode;
        this.town = town;
    }

    public Location(String locationId, String town, Integer postalCode, Boolean status, LocalDate createdAt, LocalDate updatedAt) {
        this.locationId = locationId;
        this.town = town;
        this.postalCode = postalCode;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}

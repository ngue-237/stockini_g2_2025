package com.logonedigital.stockini_g2_2025.dto;

import java.time.LocalDate;

public class CategoryResDto {
    private String idCategory;
    private String name;
    private String description;
    private String slug;

    public CategoryResDto(String idCategory, String name, String description, LocalDate createdAt, LocalDate updatedAt) {
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public String setName() {
        this.name = name;
        return null;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription() {
        this.description = description;
        return null;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }
}

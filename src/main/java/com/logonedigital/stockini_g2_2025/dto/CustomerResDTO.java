package com.logonedigital.stockini_g2_2025.dto;

import jakarta.persistence.Column;

public class CustomerResDTO {

    private String idCustomer;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private LocationResDTO locationResDTO;


    public CustomerResDTO() {
    }

    public CustomerResDTO(String idCustomer, String firstname, String lastname, String email, String phone) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public CustomerResDTO(String idCustomer, String firstname, String lastname, String email, String phone, LocationResDTO locationResDTO) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.locationResDTO = locationResDTO;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocationResDTO getLocationResDTO() {
        return locationResDTO;
    }

    public void setLocationResDTO(LocationResDTO locationResDTO) {
        this.locationResDTO = locationResDTO;
    }
}

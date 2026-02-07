package com.logonedigital.stockini_g2_2025.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class CustomerReqDTO {
    @NotEmpty(message = "Fill this field")
    private String firstname;

    private String lastname;
    @Email(message = "your email wrong")
    @NotEmpty(message = "Fill this field")
    private String email;
    @NotEmpty(message = "Fill this field")
    private String phone;
    private LocationReqDTO locationReqDTO;

    public CustomerReqDTO() {
    }

    public CustomerReqDTO(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public CustomerReqDTO(String firstname, String lastname, String email, String phone, LocationReqDTO locationReqDTO) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.locationReqDTO = locationReqDTO;
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

    public LocationReqDTO getLocationReqDTO() {
        return locationReqDTO;
    }

    public void setLocationReqDTO(LocationReqDTO locationReqDTO) {
        this.locationReqDTO = locationReqDTO;
    }
}

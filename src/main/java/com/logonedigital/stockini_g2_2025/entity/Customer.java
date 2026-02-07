package com.logonedigital.stockini_g2_2025.entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String idCustomer;

    private String firstname;

    private String lastname;

    private String email;
    @Column(name = "tel", nullable = false, unique = true)

    private String phone;
    private Boolean status;

    private LocalDate createdAt;

    private LocalDate updatedAt;
    @OneToOne
    private Location location;

    public Customer() {
    }

    public Customer(String firstname, String lastname, String email, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
    }

    public Customer(String lastname, String idCustomer, String firstname, String phone, String email) {
        this.lastname = lastname;
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
    }

    public Customer(String idCustomer, String firstname, String lastname, String email, String phone, Boolean status, LocalDate createdAt, LocalDate updatedAt, Location location) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}

package com.logonedigital.stockini_g2_2025.repository;

import com.logonedigital.stockini_g2_2025.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, String> {
}

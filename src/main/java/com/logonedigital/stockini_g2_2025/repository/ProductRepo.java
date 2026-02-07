package com.logonedigital.stockini_g2_2025.repository;

import com.logonedigital.stockini_g2_2025.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, String> {
}

package com.logonedigital.stockini_g2_2025.repository;

import com.logonedigital.stockini_g2_2025.entity.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStockRepo extends JpaRepository<ProductStock, String> {
}

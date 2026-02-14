package com.logonedigital.stockini_g2_2025.repository;

import com.logonedigital.stockini_g2_2025.entity.SalesLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleLineRepo extends JpaRepository<SalesLine, String> {
}

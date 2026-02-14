package com.logonedigital.stockini_g2_2025.repository;

import com.logonedigital.stockini_g2_2025.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface SaleRepo extends JpaRepository<Sale, String> {
    @Query("SELECT COUNT(s) FROM Sale s WHERE FUNCTION('YEAR', s.createdAt) = :annee")
    long countByYear(@Param("annee") int annee);
}

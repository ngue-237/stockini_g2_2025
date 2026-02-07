package com.logonedigital.stockini_g2_2025.repository;

import com.logonedigital.stockini_g2_2025.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,String> {
    String idCategory(String idCategory);
}

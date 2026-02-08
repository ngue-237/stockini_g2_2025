package com.logonedigital.stockini_g2_2025.service.category;

import com.logonedigital.stockini_g2_2025.dto.CategoryReqDto;
import com.logonedigital.stockini_g2_2025.dto.CategoryResDto;

import java.util.List;

public interface CategoryService {

    void addCategory(CategoryReqDto categoryReqDto);
    CategoryResDto getCategoryById (String idCategorie);
    List<CategoryResDto> getAllCategory();
    void updateCategory (String categoryId, CategoryReqDto categoryReqDto);
    void deleteCategory (String categoryId);
}

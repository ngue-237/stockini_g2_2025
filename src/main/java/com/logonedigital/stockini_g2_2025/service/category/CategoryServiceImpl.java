package com.logonedigital.stockini_g2_2025.service.category;

import com.logonedigital.stockini_g2_2025.dto.CategoryReqDto;
import com.logonedigital.stockini_g2_2025.dto.CategoryResDto;
import com.logonedigital.stockini_g2_2025.entity.Category;
import com.logonedigital.stockini_g2_2025.exception.ResourceNotFoundException;
import com.logonedigital.stockini_g2_2025.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;

    }

    @Override
    public void addCategory(CategoryReqDto categoryReqDto) {
        Category category = new Category(categoryReqDto.getName(),categoryReqDto.getDescription());
        this.categoryRepo.save(category);
    }

    @Override
    public CategoryResDto getCategoryById(String idCategory) {
        Category category= this.categoryRepo.findById(idCategory).orElseThrow(()-> new ResourceNotFoundException("Category not found "));
        return new CategoryResDto(category.getIdCategory(), category.getName(), category.getDescription(),
                category.getCreatedAt(), category.getUpdatedAt());
    }

    @Override
    public List<CategoryResDto> getAllCategory() {
        return this.categoryRepo.findAll().
                stream()
                .map( category-> {
                    return new CategoryResDto(category.getIdCategory(), category.getName(),
                            category.getDescription(), category.getCreatedAt(),
                            category.getUpdatedAt()
                    );}
                ).toList();
    }

    @Override
    public void updateCategory(String categoryId, CategoryResDto categoryResDto) {
        Optional<Category> oldCategory = this.categoryRepo.findById(categoryId);

        if (oldCategory.isEmpty())
            throw new ResourceNotFoundException("No Category Found");

        oldCategory.get().setName(categoryResDto.setName());
        oldCategory.get().setDescription(categoryResDto.setDescription());

        this.categoryRepo.saveAndFlush(oldCategory.get());
    }

    @Override
    public void deleteCategory(String categoryId) {
        this.categoryRepo.deleteById(categoryId);
    }
}

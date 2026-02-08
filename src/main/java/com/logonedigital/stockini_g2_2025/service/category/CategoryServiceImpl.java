package com.logonedigital.stockini_g2_2025.service.category;

import com.github.slugify.Slugify;
import com.logonedigital.stockini_g2_2025.dto.CategoryReqDto;
import com.logonedigital.stockini_g2_2025.dto.CategoryResDto;
import com.logonedigital.stockini_g2_2025.entity.Category;
import com.logonedigital.stockini_g2_2025.exception.ResourceNotFoundException;
import com.logonedigital.stockini_g2_2025.repository.CategoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepo categoryRepo;

    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;

    }

    @Override
    public void addCategory(CategoryReqDto categoryReqDto) {
        final Slugify slg = Slugify.builder().build();

        Category category = new Category(categoryReqDto.getName(),categoryReqDto.getDescription());
        category.setCreatedAt(LocalDate.now());
        category.setSlug(slg.slugify(categoryReqDto.getName()));
        category.setStatus(true);

        this.categoryRepo.save(category);
    }

    @Override
    public CategoryResDto getCategoryById(String idCategory) {
        Category category= this.categoryRepo.findById(idCategory).orElseThrow(()-> new ResourceNotFoundException("Category not found "));
        return new CategoryResDto(category.getIdCategory(),category.getName(),
                category.getDescription(),category.getSlug());
    }

    @Override
    public List<CategoryResDto> getAllCategory() {
        return this.categoryRepo.findAll().
                stream()
                .map( category-> new CategoryResDto(category.getIdCategory(),category.getName(),
                        category.getDescription(),category.getSlug())
                ).toList();
    }

    @Override
    public void updateCategory(String categoryId, CategoryReqDto categoryReqDto) {
        Optional<Category> oldCategory = this.categoryRepo.findById(categoryId);
        final Slugify slg = Slugify.builder().build();

        if (oldCategory.isEmpty())
            throw new ResourceNotFoundException("No Category Found");

        oldCategory.get().setName(categoryReqDto.getName());
        oldCategory.get().setDescription(categoryReqDto.getDescription());
        oldCategory.get().setSlug(slg.slugify(categoryReqDto.getName()));
        oldCategory.get().setUpdatedAt(LocalDate.now());
        this.categoryRepo.saveAndFlush(oldCategory.get());
    }

    @Override
    public void deleteCategory(String categoryId) {
        this.categoryRepo.deleteById(categoryId);
    }
}

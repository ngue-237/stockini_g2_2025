package com.logonedigital.stockini_g2_2025.controller;

import com.logonedigital.stockini_g2_2025.dto.CategoryReqDto;
import com.logonedigital.stockini_g2_2025.dto.CategoryResDto;
import com.logonedigital.stockini_g2_2025.service.category.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addCategory(@RequestBody CategoryReqDto categoryReqDto){

        this.categoryService.addCategory(categoryReqDto);
        return ResponseEntity.status(201).body("Category created successfully !");
    }

    @GetMapping(path = "/get_by_id/{idCategory}")
    public ResponseEntity<CategoryResDto> getCategory(@PathVariable String idCategory){
        return ResponseEntity.status(200).body(this.categoryService.getCategoryById(idCategory));
    }

    @GetMapping(path = "/get_all")
    public ResponseEntity<List<CategoryResDto>> getCategories(){
        return ResponseEntity.status(200).body(this.categoryService.getAllCategory());
    }

    @PutMapping(path = "/update_by_id/{idCategory}")
    public ResponseEntity<String> updateCategory(@PathVariable String idCategory, @RequestBody CategoryReqDto categoryReqDto){
        this.categoryService.updateCategory(idCategory, categoryReqDto);
        return ResponseEntity.status(202).body("Category updated successfully");
    }

    @DeleteMapping(path = "/delete_by_id/{idCategory}")
    public ResponseEntity<String> deleteCategory(@PathVariable String idCategory){
        this.categoryService.deleteCategory(idCategory);
        return ResponseEntity.status(202).body("Category deleted successfully");
    }

}

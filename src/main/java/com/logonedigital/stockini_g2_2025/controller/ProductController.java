package com.logonedigital.stockini_g2_2025.controller;

import com.logonedigital.stockini_g2_2025.dto.ProductReqDTO;
import com.logonedigital.stockini_g2_2025.dto.ProductResDTO;
import com.logonedigital.stockini_g2_2025.service.product.ProductService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> addProduct(@Valid @RequestBody ProductReqDTO productReqDTO){

        this.productService.addProduct(productReqDTO);

        return ResponseEntity.status(201).body("Product created successfully!");
    }

    @GetMapping(path="/get_by_id/{idProduct}")
    public ResponseEntity<ProductResDTO> getProduct(@PathVariable String idProduct){
        return ResponseEntity.status(200).body(
                this.productService.getProductById(idProduct)
        );
    }

    @GetMapping(path = "/get_all")
    public ResponseEntity<List<ProductResDTO>> getProducts(){
        return ResponseEntity.status(200).body(
                this.productService.getAllProduct()
        );
    }

    @PutMapping(path = "/update_by_id/{idProduct}")
    public ResponseEntity<String> updateProductById(@PathVariable String idProduct, @Valid @RequestBody ProductReqDTO productReqDTO){

        this.productService.updateProductById(idProduct, productReqDTO);

        return ResponseEntity.status(202).body("Product updated successfully !");
    }

    @DeleteMapping(path = "/delete_by_id/{idProduct}")
    public ResponseEntity<String> deleteProductById(@PathVariable String idProduct){
        this.productService.deleteProductById(idProduct);
        return ResponseEntity.status(202).body("Product deleted successfully !");
    }



}

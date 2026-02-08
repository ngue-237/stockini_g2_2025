package com.logonedigital.stockini_g2_2025.service.product;

import com.logonedigital.stockini_g2_2025.dto.ProductReqDTO;
import com.logonedigital.stockini_g2_2025.dto.ProductResDTO;

import java.util.List;

public interface ProductService {

    void addProduct(ProductReqDTO productReqDTO);
    ProductResDTO getProductById(String idProduct);
    List<ProductResDTO> getAllProduct();
    void updateProductById(String idProduct, ProductReqDTO productReqDTO);
    void deleteProductById(String idProduct);
}

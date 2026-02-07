package com.logonedigital.stockini_g2_2025.service.product;

import com.logonedigital.stockini_g2_2025.dto.ProductReqDTO;
import com.logonedigital.stockini_g2_2025.dto.ProductResDTO;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Override
    public void addProduct(ProductReqDTO productReqDTO) {

    }

    @Override
    public ProductResDTO getProductById(String idProduct) {
        return null;
    }

    @Override
    public List<ProductResDTO> getAllProduct() {
        return List.of();
    }

    @Override
    public void updateProductById(String idProduct, ProductReqDTO productReqDTO) {

    }

    @Override
    public void deleteProductById(String idProduct) {

    }
}

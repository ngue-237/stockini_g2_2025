package com.logonedigital.stockini_g2_2025.service.product;

import com.github.slugify.Slugify;
import com.logonedigital.stockini_g2_2025.dto.ProductReqDTO;
import com.logonedigital.stockini_g2_2025.dto.ProductResDTO;
import com.logonedigital.stockini_g2_2025.entity.Product;
import com.logonedigital.stockini_g2_2025.exception.ResourceNotFoundException;
import com.logonedigital.stockini_g2_2025.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void addProduct(ProductReqDTO productReqDTO) {
        final Slugify slg = Slugify.builder().build();

        Product product = new Product(productReqDTO.getName(),productReqDTO.getDescription(), productReqDTO.getPrice());
        product.setStatus(true);

        product.setSlug(slg.slugify(productReqDTO.getName()));
        product.setCreatedAt(LocalDate.now());

        this.productRepo.save(product);
    }

    @Override
    public ProductResDTO getProductById(String idProduct) {
        Product product = this.productRepo.findById(idProduct)
                .orElseThrow(()->new ResourceNotFoundException("Product does'nt exist !"));

        return new ProductResDTO(product.getIdProduct(), product.getName(),
                product.getDescription(),product.getSlug(), product.getPrice());
    }

    @Override
    public List<ProductResDTO> getAllProduct() {
        return this.productRepo.findAll().stream().map(product ->new ProductResDTO(product.getIdProduct(), product.getName(),
                product.getDescription(),product.getSlug(),  product.getPrice())).toList();
    }

    @Override
    public void updateProductById(String idProduct, ProductReqDTO productReqDTO) {
        final Slugify slg = Slugify.builder().build();
        Product product = this.productRepo.findById(idProduct)
                .orElseThrow(()->new ResourceNotFoundException("Product does'nt exist !"));

        //TODO: régler le pb avec les slup
        product.setName(productReqDTO.getName());
        product.setDescription(productReqDTO.getDescription());
        product.setPrice(productReqDTO.getPrice());
        product.setSlug(slg.slugify(productReqDTO.getName()));
        product.setCreatedAt(LocalDate.now());

        this.productRepo.saveAndFlush(product);
    }

    @Override
    public void deleteProductById(String idProduct) {
        Product product = this.productRepo.findById(idProduct)
                .orElseThrow(()->new ResourceNotFoundException("Product does'nt exist !"));

        this.productRepo.delete(product);
    }
}

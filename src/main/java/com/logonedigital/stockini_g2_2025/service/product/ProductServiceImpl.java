package com.logonedigital.stockini_g2_2025.service.product;

import com.github.slugify.Slugify;
import com.logonedigital.stockini_g2_2025.dto.ProductReqDTO;
import com.logonedigital.stockini_g2_2025.dto.ProductResDTO;
import com.logonedigital.stockini_g2_2025.entity.Product;
import com.logonedigital.stockini_g2_2025.entity.ProductStock;
import com.logonedigital.stockini_g2_2025.exception.ResourceNotFoundException;
import com.logonedigital.stockini_g2_2025.repository.ProductRepo;
import com.logonedigital.stockini_g2_2025.repository.ProductStockRepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepo productRepo;
    private final ProductStockRepo productStockRepo;

    public ProductServiceImpl(ProductRepo productRepo, ProductStockRepo productStockRepo) {
        this.productRepo = productRepo;
        this.productStockRepo = productStockRepo;
    }

    @Override
    public void addProduct(ProductReqDTO productReqDTO) {
        final Slugify slg = Slugify.builder().build();

        Product product = new Product(productReqDTO.getName(),productReqDTO.getDescription(), productReqDTO.getPrice());
        product.setStatus(true);

        product.setSlug(slg.slugify(productReqDTO.getName()));
        product.setCreatedAt(LocalDate.now());


        ProductStock productStockSaved = this.productStockRepo.save(new ProductStock(productReqDTO.getQuantity(), LocalDate.now()));
        product.setProductStock(productStockSaved);

        this.productRepo.save(product);
    }

    @Override
    public ProductResDTO getProductById(String idProduct) {
        Product product = this.productRepo.findById(idProduct)
                .orElseThrow(()->new ResourceNotFoundException("Product does'nt exist !"));

        if(product.getProductStock()==null)
            return  new ProductResDTO(product.getIdProduct(), product.getName(),
                    product.getDescription(),product.getSlug(), product.getPrice());
        else
            return new ProductResDTO(product.getIdProduct(), product.getName(),
                    product.getDescription(),product.getSlug(), product.getPrice(), product.getProductStock().getQuantity());
    }

    @Override
    public List<ProductResDTO> getAllProduct() {
        return this.productRepo.findAll().stream().map(product ->{
            if(product.getProductStock()==null)
                return  new ProductResDTO(product.getIdProduct(), product.getName(),
                        product.getDescription(),product.getSlug(), product.getPrice());
            else
                return new ProductResDTO(product.getIdProduct(), product.getName(),
                        product.getDescription(),product.getSlug(), product.getPrice(), product.getProductStock().getQuantity());

        }).toList();
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

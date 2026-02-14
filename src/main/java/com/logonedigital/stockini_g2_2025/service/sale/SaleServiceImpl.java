package com.logonedigital.stockini_g2_2025.service.sale;

import com.logonedigital.stockini_g2_2025.dto.SaleLineReqDTO;
import com.logonedigital.stockini_g2_2025.entity.*;
import com.logonedigital.stockini_g2_2025.exception.ResourceNotFoundException;
import com.logonedigital.stockini_g2_2025.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService{
    private final SaleLineRepo saleLineRepo;
    private final SaleRepo saleRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepo productRepo;
    private final ProductStockRepo productStockRepo;

    public SaleServiceImpl(SaleLineRepo saleLineRepo, SaleRepo saleRepo, CustomerRepo customerRepo, ProductRepo productRepo, ProductStockRepo productStockRepo) {
        this.saleLineRepo = saleLineRepo;
        this.saleRepo = saleRepo;
        this.customerRepo = customerRepo;
        this.productRepo = productRepo;
        this.productStockRepo = productStockRepo;
    }

    @Transactional
    @Override
    public void addSale(String idCustomer, List<SaleLineReqDTO> saleLineDTO) {

        Customer customer = this.customerRepo.findById(idCustomer)
                .orElseThrow(()->new ResourceNotFoundException("Customer doesn't exist !"));

        List<SalesLine> salesLines = saleLineDTO.stream().map((saleLineReqDTO)->{
            Product product = this.productRepo.findById(saleLineReqDTO.getIdProduct()).orElseThrow(()->new ResourceNotFoundException("Product doesn't exist !"));
            SalesLine salesLine = new SalesLine();
            salesLine.setQuantity(saleLineReqDTO.getQuantite());
            salesLine.setProduct(product);
            salesLine.setUnitPrice(product.getPrice());
            salesLine.setSubtotal(saleLineReqDTO.getQuantite()*product.getPrice());
            ProductStock productStock = product.getProductStock();
            productStock.setQuantity(productStock.getQuantity()-saleLineReqDTO.getQuantite());
            this.productStockRepo.saveAndFlush(productStock);

            return salesLine;
        }).toList();
        this.saleLineRepo.saveAll(salesLines);
        long count = this.saleRepo.countByYear(LocalDate.now().getYear()) + 1;

        String reference = "VTE-" + LocalDate.now().getYear() + "-"
                + String.format("%05d", count);

        Sale sale = new Sale();
        sale.setReference(reference);
        sale.setSalesLine(salesLines);
        Double totalHT = salesLines.stream().map(SalesLine::getSubtotal).reduce(0.0, Double::sum);
        sale.setTotalHT(totalHT);
        sale.setCreatedAt(LocalDateTime.now());
        sale.setStatus(true);
        sale.setTotalTTC(totalHT+(totalHT*19.25)/100);

        this.saleRepo.save(sale);

    }
}

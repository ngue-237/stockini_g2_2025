package com.logonedigital.stockini_g2_2025.controller;

import com.logonedigital.stockini_g2_2025.dto.SaleRequestDTO;
import com.logonedigital.stockini_g2_2025.service.sale.SaleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createNewSale(@RequestBody @Valid SaleRequestDTO saleRequestDTO){
        this.saleService.addSale(saleRequestDTO.getIdCustomer(), saleRequestDTO.getSaleLineReqDTOS());

        return ResponseEntity.status(201).body("Sale added sucessfully !");
    }
}

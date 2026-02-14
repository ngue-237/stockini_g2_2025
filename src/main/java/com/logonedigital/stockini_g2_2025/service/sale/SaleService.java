package com.logonedigital.stockini_g2_2025.service.sale;

import com.logonedigital.stockini_g2_2025.dto.SaleLineReqDTO;

import java.util.List;

public interface SaleService {
    void addSale(String idCustomer, List<SaleLineReqDTO> saleLineDTO);

}

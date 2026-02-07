package com.logonedigital.stockini_g2_2025.service.customer;

import com.logonedigital.stockini_g2_2025.dto.CustomerReqDTO;
import com.logonedigital.stockini_g2_2025.dto.CustomerResDTO;
import com.logonedigital.stockini_g2_2025.entity.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(CustomerReqDTO customerReqDTO);
    CustomerResDTO getCustomerById(String idCustomer);
    List<CustomerResDTO> getAllCustomer();
    void updateCustomer(String idCustomer, Customer customer);
    void deleteCustomer(String idCustomer);
}

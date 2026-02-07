package com.logonedigital.stockini_g2_2025.controller;

import com.logonedigital.stockini_g2_2025.dto.CustomerReqDTO;
import com.logonedigital.stockini_g2_2025.dto.CustomerResDTO;
import com.logonedigital.stockini_g2_2025.entity.Customer;
import com.logonedigital.stockini_g2_2025.service.customer.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<String> createNewCustomer(@RequestBody @Valid CustomerReqDTO customerReqDTO){
        this.customerService.addCustomer(customerReqDTO);
        return ResponseEntity.status(201).body("Customer created successfully !");
    }

    @GetMapping(path = "/get_customer_by_id/{idCustomer}")
    public ResponseEntity<CustomerResDTO> getCustomer(@PathVariable String idCustomer){
        return ResponseEntity.status(200).body(this.customerService.getCustomerById(idCustomer));
    }

    @GetMapping(path = "/get_all_customer")
    public ResponseEntity<List<CustomerResDTO>> getAllCustomers(){
        return ResponseEntity.status(200).body(this.customerService.getAllCustomer());
    }

    @PatchMapping(path = "/update_by_id/{idCustomer}")
    public ResponseEntity<String> updateCustomer(@PathVariable String idCustomer,@RequestBody Customer customer){
        this.customerService.updateCustomer(idCustomer, customer);
        return ResponseEntity.status(202).body("Updated successfully!");
    }

    @DeleteMapping(path = "delete_by_id/{idCustomer}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String idCustomer){
        this.customerService.deleteCustomer(idCustomer);
        return ResponseEntity.status(202).body("Deleted successfully!");
    }
}

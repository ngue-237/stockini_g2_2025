package com.logonedigital.stockini_g2_2025.service.customer;

import com.logonedigital.stockini_g2_2025.dto.CustomerReqDTO;
import com.logonedigital.stockini_g2_2025.dto.CustomerResDTO;
import com.logonedigital.stockini_g2_2025.dto.LocationResDTO;
import com.logonedigital.stockini_g2_2025.entity.Customer;
import com.logonedigital.stockini_g2_2025.entity.Location;
import com.logonedigital.stockini_g2_2025.exception.ResourceNotFoundException;
import com.logonedigital.stockini_g2_2025.repository.CustomerRepo;
import com.logonedigital.stockini_g2_2025.repository.LocationRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;
    private final LocationRepo locationRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo, LocationRepo locationRepo) {
        this.customerRepo = customerRepo;
        this.locationRepo = locationRepo;
    }


    @Override
    public void addCustomer(CustomerReqDTO customerReqDTO) {

        Customer customer = new Customer(customerReqDTO.getFirstname(),
                customerReqDTO.getLastname(), customerReqDTO.getEmail(),
                customerReqDTO.getPhone());

        customer.setCreatedAt(LocalDate.now());
        customer.setStatus(true);

        Location location = new Location(customerReqDTO.getLocationReqDTO().getPostalCode(), customerReqDTO.getLocationReqDTO().getTown());
        location.setCreatedAt(LocalDate.now());
        location.setStatus(true);
        Location locationSaved = this.locationRepo.save(location);
        customer.setLocation(locationSaved);
        this.customerRepo.save(customer);
    }

    @Override
    public CustomerResDTO getCustomerById(String idCustomer) {
        Customer customer = this.customerRepo.findById(idCustomer).orElseThrow(()->new ResourceNotFoundException("Customer with id "+idCustomer+" not found !"));
        LocationResDTO locationResDTO = new LocationResDTO(customer.getLocation().getLocationId(),
                customer.getLocation().getTown(), customer.getLocation().getPostalCode());
        return new CustomerResDTO(customer.getIdCustomer(), customer.getFirstname(),
                customer.getLastname(),customer.getEmail(),customer.getPhone(), locationResDTO);
    }

    @Override
    public List<CustomerResDTO> getAllCustomer() {
        return this.customerRepo.findAll()
                .stream().map(customer -> {
                    if(customer.getLocation()==null)
                        return new CustomerResDTO(customer.getIdCustomer(), customer.getFirstname(),
                                customer.getLastname(),customer.getEmail(),customer.getPhone());
                    else {
                        LocationResDTO locationResDTO = new LocationResDTO(customer.getLocation().getLocationId(),
                                customer.getLocation().getTown(), customer.getLocation().getPostalCode());

                        return new CustomerResDTO(customer.getIdCustomer(), customer.getFirstname(),
                                customer.getLastname(),customer.getEmail(),customer.getPhone(), locationResDTO);
                    }

                }).toList();
    }

    @Override
    public void updateCustomer(String idCustomer, Customer customer) {

        //Rechercher l'ancien customer
        Optional<Customer> oldCustomer = this.customerRepo.findById(idCustomer);
        if(oldCustomer.isEmpty())
            throw  new ResourceNotFoundException("Customer with id "+idCustomer+" not found !");

        //Modifier les valeurs de l'ancien customer
        oldCustomer.get().setLastname(customer.getLastname());
        oldCustomer.get().setFirstname(customer.getFirstname());
        oldCustomer.get().setEmail(customer.getEmail());
        oldCustomer.get().setPhone(customer.getPhone());
        oldCustomer.get().setUpdatedAt(LocalDate.now());

        //sauvegarde
        this.customerRepo.saveAndFlush(oldCustomer.get());
    }

    @Override
    public void deleteCustomer(String idCustomer) {
        this.customerRepo.deleteById(idCustomer);
    }
}

package com.cg.controller.restful;

import com.cg.exception.DataInputException;
import com.cg.model.Customer;
import com.cg.model.LocationRegion;
import com.cg.model.dto.CustomerCreReqDTO;
import com.cg.model.dto.CustomerResDTO;
import com.cg.repository.CustomerRepository;
import com.cg.repository.LocotionRegionRepository;
import com.cg.service.customer.CustomerService;
import com.cg.service.customer.ICustomerService;
import com.cg.ultis.AppUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private AppUtils appUtils;
    @Autowired
    private ICustomerService customerService;
    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Customer> customers = customerService.findAll();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@Validated @RequestBody CustomerCreReqDTO customerCreReqDTO, BindingResult bindingResult){
        new CustomerCreReqDTO().validate(customerCreReqDTO, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return appUtils.mapErrorToResponse(bindingResult);
        }
        Customer customer = customerCreReqDTO.toCustomer();
        customer.setBalance(BigDecimal.ZERO);
        customer.setDeleted(false);
        customerService.create(customer);

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }
    @GetMapping("/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId){

        Customer customer = customerService.findById(customerId).orElseThrow(() -> {
            throw new DataInputException("Customer not found");
        });
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
}

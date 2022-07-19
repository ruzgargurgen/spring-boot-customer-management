package com.rgurgen.customermanagement.controller;

import com.rgurgen.customermanagement.dtos.CustomerDto;
import com.rgurgen.customermanagement.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.saveCustomer(customerDto));
    }
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {

        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping(path = "{fistName}")
    public ResponseEntity<CustomerDto> findByFirstName(@PathVariable(value = "fistName") String firstName) {
        return ResponseEntity.ok(customerService.findByFirstName(firstName));
    }

    @PutMapping(path = "{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@Valid @PathVariable(value = "customerId") Long id, @RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, customerDto));
    }

    @DeleteMapping(path = "{customerId}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable(value = "customerId") Long id) {
        return ResponseEntity.ok(customerService.delete(id));
    }
}


package com.rgurgen.customermanagement.service;

import com.rgurgen.customermanagement.dtos.CustomerDto;

import java.util.List;

public interface CustomerService {

    CustomerDto saveCustomer(CustomerDto customerDto);

    List<CustomerDto> getAllCustomers();

    CustomerDto updateCustomer(Long id, CustomerDto customerDto);

    Boolean delete(Long id);

    CustomerDto findByFirstName(String firstName);
}

package com.rgurgen.customermanagement.service.impl;

import com.rgurgen.customermanagement.dtos.CustomerDto;
import com.rgurgen.customermanagement.mapper.CustomerMapper;
import com.rgurgen.customermanagement.model.Customer;
import com.rgurgen.customermanagement.repos.CustomerRepository;
import com.rgurgen.customermanagement.service.CustomerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        Customer customer = customerRepository.findByEmail(customerDto.getEmail()).orElse(null);
        if (customer == null) {
            customer=customerMapper.customerDtoToCustomer(customerDto);
            customerDto=customerMapper.customerToCustomerDto(customerRepository.save(customer));
            return customerDto;
        }
        throw new IllegalArgumentException("Customer email already exist");
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<CustomerDto> customers = customerMapper.customersToCustomersDto(customerRepository.findAll());
        return customers;
    }

    @Override
    public CustomerDto findByFirstName(String firstName) {
        Customer customer = customerRepository.findByFirstName(firstName)
                .orElseThrow(() -> new IllegalArgumentException("Customer Name " + firstName + " not found"));
        return customerMapper.customerToCustomerDto(customer);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer Id" + id + " not found"));
        customer.setFirstname(customerDto.getFirstname());
        customer.setLastname(customerDto.getLastname());
        customer.setGender(customerDto.getGender());
        customer.setEmail(customerDto.getEmail());
        return customerMapper.customerToCustomerDto(customerRepository.save(customer));

    }

    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public Boolean delete(Long id) {
        customerRepository.deleteById(id);
        return true;
    }
}

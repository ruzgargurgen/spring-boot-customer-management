package com.rgurgen.customermanagement.mapper;

import com.rgurgen.customermanagement.dtos.CustomerDto;
import com.rgurgen.customermanagement.model.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer customerDtoToCustomer(CustomerDto customerDto);

    CustomerDto customerToCustomerDto(Customer customer);

    List<Customer> customersDtoToCustomers(List<CustomerDto> dtoList);

    List<CustomerDto> customersToCustomersDto(List<Customer> customers);

}

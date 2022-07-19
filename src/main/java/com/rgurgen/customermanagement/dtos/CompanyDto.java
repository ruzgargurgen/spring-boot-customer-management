package com.rgurgen.customermanagement.dtos;

import com.rgurgen.customermanagement.model.Address;
import com.rgurgen.customermanagement.model.Customer;

public class CompanyDto extends BaseDto<Long>{

    private String name;

    private String code;

    private Boolean description;

    private Customer customer;

    private Address address;

    public CompanyDto() {
    }

    public CompanyDto(String name, String code, Boolean description, Customer customer, Address address) {
        this.name = name;
        this.code = code;
        this.description = description;
        this.customer = customer;
        this.address = address;
    }

    public CompanyDto(String code, String name, String code1, Boolean description, Customer customer, Address address) {
        super(code);
        this.name = name;
        this.code = code1;
        this.description = description;
        this.customer = customer;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getDescription() {
        return description;
    }

    public void setDescription(Boolean description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

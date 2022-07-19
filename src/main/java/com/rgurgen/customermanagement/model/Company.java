package com.rgurgen.customermanagement.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Company extends BaseEntity<Long>{

    private String name;

    private String description;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Customer customer;

    public Company() {
    }

    public Company(String name, String description, Customer customer) {
        this.name = name;
        this.description = description;
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

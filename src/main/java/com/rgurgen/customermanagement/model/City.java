package com.rgurgen.customermanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class City extends BaseEntity<Long> {

    private String name;

    @OneToOne(mappedBy = "country")
    private Address address;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Country country;

    @OneToMany(mappedBy = "city")
    private List<Town> towns;

    public City(String name, Address address, Country country) {
        this.name = name;
        this.address = address;
        this.country = country;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Town> getTowns() {
        return towns;
    }

    public void setTowns(List<Town> towns) {
        this.towns = towns;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}

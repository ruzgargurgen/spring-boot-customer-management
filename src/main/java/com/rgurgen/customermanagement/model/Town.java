package com.rgurgen.customermanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Town extends BaseEntity<Long>{

    private String name;

    @OneToOne(mappedBy = "country")
    private Address address;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private City city;

    public Town() {
    }

    public Town(String name, Address address, City city) {
        this.name = name;
        this.address = address;
        this.city = city;
    }

    @OneToMany(mappedBy = "town")
    private List<District> districts;

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
}

package com.rgurgen.customermanagement.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class District extends BaseEntity<Long>{

    private String name;

    @OneToOne(mappedBy = "district")
    private Address address;

    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private Town town;

    @OneToMany(mappedBy = "district")
    private List<Street> streets;

    public District() {
    }

    public District(String name, Address address, Town town) {
        this.name = name;
        this.address = address;
        this.town = town;
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

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public List<Street> getStreets() {
        return streets;
    }

    public void setStreets(List<Street> streets) {
        this.streets = streets;
    }
}

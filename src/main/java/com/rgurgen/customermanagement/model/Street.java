package com.rgurgen.customermanagement.model;

import javax.persistence.*;

@Entity
public class Street extends BaseEntity<Long> {

    private String name;

    @OneToOne(mappedBy = "street")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "districtId")
    private District district;

    public Street() {
    }

    public Street(String name, Address address, District district) {
        this.name = name;
        this.address = address;
        this.district = district;
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

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
}


package com.rgurgen.customermanagement.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Entity
public class Address extends BaseEntity<Long>{

    @OneToOne
    @JoinColumn(name="countryId")
    private Country country;

    @OneToOne
    @JoinColumn(name="cityId")
    private City city;

    @OneToOne
    @JoinColumn(name="townId")
    private Town town;

    @OneToOne
    @JoinColumn(name="districtId")
    private District district;

    @OneToOne
    @JoinColumn(name="streetId")
    private Street street;

    private String no;

    private  String homeNo;

    @ManyToMany(mappedBy = "address")
    List<Customer> customers;

    public Address(String code, Long createdBy, Date creationDate, Long lastModifiedBy, Date lastModifiedDate, Country country, City city, Town town, District district, Street street, String no, String homeNo) {
        this.country = country;
        this.city = city;
        this.town = town;
        this.district = district;
        this.street = street;
        this.no = no;
        this.homeNo = homeNo;
    }

    public Address() {
        super();
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getHomeNo() {
        return homeNo;
    }

    public void setHomeNo(String homeNo) {
        this.homeNo = homeNo;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}

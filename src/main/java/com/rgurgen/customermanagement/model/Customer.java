package com.rgurgen.customermanagement.model;

import com.rgurgen.customermanagement.enums.AddressType;
import com.rgurgen.customermanagement.enums.Gender;
import com.rgurgen.customermanagement.enums.PhoneType;

import javax.persistence.*;
import java.util.Map;

@Entity
public class Customer extends BaseEntity<Long>{

    @Column(name = "FirstName", length = 30, nullable = false)
    private String firstname;

    @Column(name = "LastName", length = 30, nullable = false)
    private String lastname;

    @Enumerated(EnumType.STRING)
    @Column(name = "Gender", nullable = false)
    private Gender gender;

    @Column(name = "Email", length = 50, nullable = false, unique = true)
    private String email;

    @ElementCollection
    @CollectionTable(name="customer_phones",joinColumns = @JoinColumn(name = "customer_id",referencedColumnName = "id"))
    @MapKeyColumn(name = "type")
    @MapKeyEnumerated(EnumType.STRING)
    @Column(name="number")
    private Map<PhoneType,String> phones;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="customer_address",joinColumns = @JoinColumn(name="customerId"),inverseJoinColumns = @JoinColumn(name = "address_id"))
    @MapKeyColumn(name = "type")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<AddressType,Address> address;

    public Customer() {
    }

    public Customer(String firstname, String lastname, Gender gender, String email, Map<PhoneType, String> phones, Map<AddressType, Address> address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.email = email;
        this.phones = phones;
        this.address = address;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<PhoneType, String> getPhones() {
        return phones;
    }

    public void setPhones(Map<PhoneType, String> phones) {
        this.phones = phones;
    }

    public Map<AddressType, Address> getAddress() {
        return address;
    }

    public void setAddress(Map<AddressType, Address> address) {
        this.address = address;
    }
}

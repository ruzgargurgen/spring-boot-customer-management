package com.rgurgen.customermanagement.dtos;

import com.rgurgen.customermanagement.enums.AddressType;
import com.rgurgen.customermanagement.enums.Gender;
import com.rgurgen.customermanagement.enums.PhoneType;
import com.rgurgen.customermanagement.model.Address;

import java.util.Map;

public class CustomerDto extends BaseDto<Long>{

    private String firstname;

    private String lastname;

    private Gender gender;

    private String email;

    private Map<PhoneType,String> phones;

    private Map<AddressType,Address> address;

    public CustomerDto() {
    }

    public CustomerDto(String code, String firstname, String lastname, Gender gender, String email, Map<PhoneType, String> phones, Map<AddressType, Address> address) {
        super(code);
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

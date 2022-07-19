package com.rgurgen.customermanagement.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
@Data
public class Country extends BaseEntity<Long> {

    private String name;

    @OneToOne(mappedBy = "country")
    private Address address;

    @OneToMany(mappedBy = "country")
    private List<City> cities;
}

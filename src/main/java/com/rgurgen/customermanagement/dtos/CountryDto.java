package com.rgurgen.customermanagement.dtos;

public class CountryDto extends BaseDto<Long>{

    private String name;

    public CountryDto() {
    }

    public CountryDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

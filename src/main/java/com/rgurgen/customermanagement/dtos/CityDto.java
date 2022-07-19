package com.rgurgen.customermanagement.dtos;

public class CityDto extends BaseDto<Long> {

    private String name;

    private CountryDto countryDto;

    public CityDto() {
    }

    public CityDto(String code, String name, CountryDto countryDto) {
        super(code);
        this.name = name;
        this.countryDto = countryDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDto getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }
}

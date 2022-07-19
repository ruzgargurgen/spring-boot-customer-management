package com.rgurgen.customermanagement.dtos;

public class TownDto extends BaseDto<Long> {

    private String name;

    private CityDto cityDto;

    public TownDto() {
    }

    public TownDto(String code, String name, CityDto cityDto) {
        super(code);
        this.name = name;
        this.cityDto = cityDto;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

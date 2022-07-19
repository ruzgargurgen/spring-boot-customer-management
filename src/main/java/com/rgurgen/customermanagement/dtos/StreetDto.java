package com.rgurgen.customermanagement.dtos;

public class StreetDto extends BaseDto<Long>{

    private String name;

    private DistrictDto districtDto;

    public StreetDto() {
    }

    public StreetDto(String code, String name, DistrictDto districtDto) {
        super(code);
        this.name = name;
        this.districtDto = districtDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DistrictDto getDistrictDto() {
        return districtDto;
    }

    public void setDistrictDto(DistrictDto districtDto) {
        this.districtDto = districtDto;
    }
}

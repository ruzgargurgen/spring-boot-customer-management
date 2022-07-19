package com.rgurgen.customermanagement.dtos;

public class DistrictDto extends BaseDto<Long> {

    private String name;

    private TownDto townDto;

    public DistrictDto() {
    }

    public DistrictDto(String code, String name, TownDto townDto) {
        super(code);
        this.name = name;
        this.townDto = townDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TownDto getTownDto() {
        return townDto;
    }

    public void setTownDto(TownDto townDto) {
        this.townDto = townDto;
    }
}

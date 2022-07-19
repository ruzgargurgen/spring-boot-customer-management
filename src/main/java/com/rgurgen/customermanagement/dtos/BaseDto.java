package com.rgurgen.customermanagement.dtos;

public abstract class BaseDto<ID extends Number> {

    private ID id;

    private String code;

    public BaseDto() {
    }

    public BaseDto(String code) {
        this.code = code;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package com.rgurgen.customermanagement.exceptions;

public class NotFoundException  extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }
}

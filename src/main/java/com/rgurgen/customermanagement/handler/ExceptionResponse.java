package com.rgurgen.customermanagement.handler;

import java.time.LocalDateTime;

public class ExceptionResponse {

    private LocalDateTime timestamp;

    private String message;

    private String code;

    public ExceptionResponse() {
    }

    public ExceptionResponse(LocalDateTime timestamp, String message, String code) {
        this.timestamp = timestamp;
        this.message = message;
        this.code = code;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

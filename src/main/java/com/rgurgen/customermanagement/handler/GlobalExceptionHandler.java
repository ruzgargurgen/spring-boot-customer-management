package com.rgurgen.customermanagement.handler;

import com.rgurgen.customermanagement.exceptions.ConstraintException;
import com.rgurgen.customermanagement.exceptions.NotFoundException;
import com.rgurgen.customermanagement.exceptions.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class, NotFoundException.class})
    public ResponseEntity<Object> handleNotFound(RuntimeException ex,WebRequest request){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setTimestamp(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setCode("404");
        return handleExceptionInternal(ex, exceptionResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(ConstraintException.class)
    public ResponseEntity<Object> handleConflict(RuntimeException ex,WebRequest request){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setTimestamp(LocalDateTime.now());
        exceptionResponse.setMessage(ex.getMessage());
        exceptionResponse.setCode("409");
        return handleExceptionInternal(ex, exceptionResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
}

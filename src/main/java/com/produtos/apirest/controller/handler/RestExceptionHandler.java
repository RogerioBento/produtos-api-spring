package com.produtos.apirest.controller.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.UnprocessableEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(value = IllegalArgumentException.class)
    private ResponseEntity unprocessableEntityExceptionHandler(RuntimeException ex, WebRequest webRequest){
        
        String bodyOfResponse = "The body of the request contains invalid values";
            return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, webRequest);
    }
}
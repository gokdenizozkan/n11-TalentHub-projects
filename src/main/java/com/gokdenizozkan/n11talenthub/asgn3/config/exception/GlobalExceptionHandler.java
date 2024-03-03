package com.gokdenizozkan.n11talenthub.asgn3.config.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<String> handleExceptionGeneral(Exception e, WebRequest request) {
        return ResponseEntity.internalServerError().body(e.getMessage() + " " + request.getContextPath());
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    protected ResponseEntity<String> handleExceptionBadRequest(HttpClientErrorException.BadRequest e, WebRequest request) {
        return ResponseEntity.badRequest().body(e.getMessage() + " " + request.getContextPath());
    }

}

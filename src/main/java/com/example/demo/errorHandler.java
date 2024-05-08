package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class errorHandler {

    @ExceptionHandler(value = Exception.class)
    public String handleException() {
        return "error";
    }
}
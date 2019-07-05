package com.example.excercise.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.NoSuchElementException;

public class Controller {

    /**
     * Exception handler if IllegalArgumentException is thrown
     *
     * @param ex
     * @return Error message String.
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String return400(IllegalArgumentException ex) {
        return ex.getMessage();

    }

}

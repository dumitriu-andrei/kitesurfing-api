package com.andreiDumitriu.Kitesurfing.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class WindNotFoundAdvice{

    @ResponseBody
    @ExceptionHandler(WindNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String windNotFoundHandler(WindNotFoundException ex) {
        return ex.getMessage();
    }
}
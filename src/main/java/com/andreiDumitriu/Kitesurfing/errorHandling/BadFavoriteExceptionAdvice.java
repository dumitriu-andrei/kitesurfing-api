package com.andreiDumitriu.Kitesurfing.errorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class BadFavoriteExceptionAdvice{

    @ResponseBody
    @ExceptionHandler(BadFavoriteException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String badFavoriteHandler(BadFavoriteException ex) {
        return ex.getMessage();
    }
}
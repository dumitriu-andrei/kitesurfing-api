package com.andreiDumitriu.Kitesurfing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class WindNotFoundException extends RuntimeException {

    @ExceptionHandler
    public ResponseEntity<Object> exception(WindNotFoundException exception){
        return new ResponseEntity<>("Wind value invalid!", HttpStatus.BAD_REQUEST);
    }


}

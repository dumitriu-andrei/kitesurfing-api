package com.andreiDumitriu.Kitesurfing.errorHandling;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(String name){
        super("Could not find country");
    }
}
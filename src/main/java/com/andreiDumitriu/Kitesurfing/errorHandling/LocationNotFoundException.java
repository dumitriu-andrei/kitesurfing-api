package com.andreiDumitriu.Kitesurfing.errorHandling;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(Long id){
        super("Could not find location "+id);
    }


}

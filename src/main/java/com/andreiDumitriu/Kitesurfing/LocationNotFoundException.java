package com.andreiDumitriu.Kitesurfing;

public class LocationNotFoundException extends RuntimeException {

    public LocationNotFoundException(Long id){
        super("Could not find location "+id);
    }


}

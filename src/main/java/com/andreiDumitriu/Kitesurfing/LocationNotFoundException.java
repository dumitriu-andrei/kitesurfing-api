package com.andreiDumitriu.Kitesurfing;

class LocationNotFoundException extends RuntimeException {

    LocationNotFoundException(Long id){
        super("Could not find location "+id);
    }


}

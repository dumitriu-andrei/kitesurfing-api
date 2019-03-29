package com.andreiDumitriu.Kitesurfing.errorHandling;

public class WindNotFoundException extends RuntimeException {

    public WindNotFoundException(int id){
        super("Wind value " + id +" is invalid! Enter a value between 0 and 100.");
    }


}
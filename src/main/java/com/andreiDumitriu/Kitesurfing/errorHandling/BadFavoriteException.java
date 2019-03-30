package com.andreiDumitriu.Kitesurfing.errorHandling;

public class BadFavoriteException extends RuntimeException {

    public BadFavoriteException(Long id){
        super("Could not find location" + id + " or location already favorited.");
    }


}
package com.andreiDumitriu.Kitesurfing;

import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
class Location {

    private @Id @GeneratedValue Long id;
    private String name;
    private Double longitude;
    private Double latitude;
    private int windProbability;
    private String country;
    private String whenToGo;

    Location(String name,Double longitude,Double latitude,
             int windProb, String country, String whenToGo){
        this.name=name;
        this.longitude=longitude;
        this.latitude=latitude;
        this.windProbability=windProb;
        this.country=country;
        this.whenToGo=whenToGo;

    }




}

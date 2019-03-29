package com.andreiDumitriu.Kitesurfing.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private Double longitude;
    private Double latitude;
    private int windProbability;
    private String country;
    private String whenToGo;

    @ManyToMany(mappedBy = "locations")
    private Set<User> users = new HashSet<>();

    public Location(String name,Double longitude,Double latitude,
             int windProb, String country, String whenToGo){
        this.name=name;
        this.longitude=longitude;
        this.latitude=latitude;
        this.windProbability=windProb;
        this.country=country;
        this.whenToGo=whenToGo;

    }

    public Location(){}




}

package com.andreiDumitriu.Kitesurfing.controllers;

import com.andreiDumitriu.Kitesurfing.errorHandling.LocationNotFoundException;
import com.andreiDumitriu.Kitesurfing.errorHandling.WindNotFoundException;
import com.andreiDumitriu.Kitesurfing.repositories.LocationRepository;
import com.andreiDumitriu.Kitesurfing.model.Location;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LocationController {

        private final LocationRepository repository;

        LocationController(LocationRepository repository){
            this.repository = repository;
        }


        @GetMapping("/spots")
        List<Location> all(){
            return repository.findAll();
        }

        @GetMapping("/spots/{id}")
        Location one(@PathVariable Long id){
            return repository.findById(id)
                    .orElseThrow(()-> new LocationNotFoundException(id));

        }

        @GetMapping("/spots/country/{country}")
        List<Location> uniqueCountry(@PathVariable String country){
            return repository.uniqueCountry(country);
        }

        @GetMapping("/spots/wind/{windProbability}")
        List<Location> uniqueWind(@PathVariable int windProbability){
            if(windProbability>0 && windProbability<=100) {
                return repository.uniqueWind(windProbability);
            }
            else throw new WindNotFoundException(windProbability);
        }

        @GetMapping("/spots/countries")
        List<String> getCountry(){
            return repository.getCountry();
        }



}

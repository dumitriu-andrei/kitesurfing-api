package com.andreiDumitriu.Kitesurfing.controllers;

import com.andreiDumitriu.Kitesurfing.LocationNotFoundException;
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


        @GetMapping("/locations")
        List<Location> all(){
            return repository.findAll();
        }

        @GetMapping("/location/{id}")
        Location one(@PathVariable Long id){
            return repository.findById(id)
                    .orElseThrow(()-> new LocationNotFoundException(id));

        }


}

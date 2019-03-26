package com.andreiDumitriu.Kitesurfing;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


@Configuration
@Slf4j
class DatabaseLoad{

    @Bean
    CommandLineRunner initDatabase(LocationRepository repository){
        return args -> {
            String fileName="C:/Users/Andrei/Desktop/Kitesurfing/data.csv";

            OpenCSVreader reader = new OpenCSVreader(fileName);
            List<String> locList = new ArrayList<>();

            locList = reader.read();

            for(int i=0;i<locList.size();i=i+6) {
                log.info("Preloading " + repository.save(new Location(locList.get(i),
                                                                      Double.parseDouble(locList.get(i+1)),
                                                                      Double.parseDouble(locList.get(i+2)),
                                                                      Integer.parseInt(locList.get(i+3)),
                                                                      locList.get(i+4),locList.get(i+5))));

            }
        };

    }
}

package com.andreiDumitriu.Kitesurfing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KitesurfingApplication {

	public static void main(String[] args) throws Exception{
		//SpringApplication.run(KitesurfingApplication.class, args);
        String fileName="C:/Users/Andrei/Desktop/Kitesurfing/data.csv";

        OpenCSVreader reader = new OpenCSVreader(fileName);

        System.out.print(reader.read());



	}

}

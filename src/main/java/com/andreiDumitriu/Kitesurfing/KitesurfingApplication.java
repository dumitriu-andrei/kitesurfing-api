package com.andreiDumitriu.Kitesurfing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class KitesurfingApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(KitesurfingApplication.class);
	}

	public static void main(String[] args) throws Exception{
		SpringApplication.run(KitesurfingApplication.class, args);




	}

}

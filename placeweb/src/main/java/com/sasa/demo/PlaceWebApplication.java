package com.sasa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
@SpringBootApplication
public class PlaceWebApplication {

    private static ConfigurableApplicationContext context;
    
    private static String[] args;

    
	public static void main(String[] args) {
		context = SpringApplication.run(PlaceWebApplication.class, args);
             
	}

        
        


}
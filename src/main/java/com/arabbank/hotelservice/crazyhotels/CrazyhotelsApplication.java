package com.arabbank.hotelservice.crazyhotels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
//@EnableOpenApi
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
@SpringBootApplication
public class CrazyhotelsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrazyhotelsApplication.class, args);
	}

}

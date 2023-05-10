package com.brewnotion.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.brewnotion.blog.entities"})  // scan JPA entities
public class BrewNotionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrewNotionServerApplication.class, args);
		System.out.println("Server ended");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}



}

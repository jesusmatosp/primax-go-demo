package com.ibm.pe.primaxgo.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableHystrix
public class CategoriaMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CategoriaMicroservicesApplication.class, args);
	}

}

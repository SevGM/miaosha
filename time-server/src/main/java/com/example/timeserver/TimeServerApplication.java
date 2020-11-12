package com.example.timeserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class TimeServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(TimeServerApplication.class, args);
	}

}

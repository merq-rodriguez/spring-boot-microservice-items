package com.example.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication()
public class SpringItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringItemsApplication.class, args);
	}

}

package com.example.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringItemsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringItemsApplication.class, args);
	}

}

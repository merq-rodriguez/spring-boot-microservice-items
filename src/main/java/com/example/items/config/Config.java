package com.example.items.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

  @Bean("ClientRest")
  @LoadBalanced
  public RestTemplate registerRestTemplate(){
    return new RestTemplate();
  }


}

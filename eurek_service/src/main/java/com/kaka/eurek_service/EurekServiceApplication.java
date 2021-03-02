package com.kaka.eurek_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekServiceApplication.class, args);
    }

}

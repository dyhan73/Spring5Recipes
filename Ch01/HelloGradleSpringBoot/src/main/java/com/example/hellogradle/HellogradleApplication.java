package com.example.hellogradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HellogradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(HellogradleApplication.class, args);
        System.out.println("Hello gradle within Spring Boot");
    }

}

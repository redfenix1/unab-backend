package com.unab.apispa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApispaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApispaApplication.class, args);
        System.out.println("Api corriendo!");
    }
}

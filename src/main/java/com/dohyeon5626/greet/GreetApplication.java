package com.dohyeon5626.greet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GreetApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetApplication.class, args);
    }

}

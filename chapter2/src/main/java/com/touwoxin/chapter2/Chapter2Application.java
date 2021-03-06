package com.touwoxin.chapter2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping
public class Chapter2Application {

    @GetMapping
    public String index(){
        return "Hello Spring Boot";
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter2Application.class, args);
    }

}

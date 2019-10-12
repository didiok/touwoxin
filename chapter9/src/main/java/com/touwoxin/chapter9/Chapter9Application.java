package com.touwoxin.chapter9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Chapter9Application {
    @RequestMapping("/")
    public String index(){
        return "第九章 单元测试";
    }
    public static void main(String[] args) {
        SpringApplication.run(Chapter9Application.class, args);
    }

}

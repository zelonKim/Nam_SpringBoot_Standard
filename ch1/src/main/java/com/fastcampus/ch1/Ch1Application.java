package com.fastcampus.ch1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch1Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch1Application.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello, Spirng Boot";
    }

}

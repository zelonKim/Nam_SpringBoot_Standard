package com.fastcampus.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController { // 원격 프로그램
    @RequestMapping("/hello")
    public String main() {
        System.out.println("hello");
        return "hello";
    }
}

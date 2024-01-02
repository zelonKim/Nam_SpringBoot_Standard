package com.fastcampus.ch2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch2Application { // 실행 시, 내장 톰캣을 띄워줌.
    public static void main(String[] args) {
        SpringApplication.run(Ch2Application.class, args);
    }

}

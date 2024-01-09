package com.fastcampus.ch3.di4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Main.class, args);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        Arrays.sort(beanDefinitionNames);
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
    @Bean
    MyBean myBean() {return new MyBean();}

}

class MyBean{}

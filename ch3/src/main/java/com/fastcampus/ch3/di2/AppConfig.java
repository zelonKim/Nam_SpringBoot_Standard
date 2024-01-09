package com.fastcampus.ch3.di2;

import org.springframework.context.annotation.Bean;

public class AppConfig {

    @Bean
    public Car car() {
        Car car = new Car();
        return car;
    }

    @Bean public Engine engine() { return new Engine();}

    @Bean public Door door() { return new Door();}
}

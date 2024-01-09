package com.fastcampus.ch3.di3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/*
@Configuration // 설정 클래스로 지정해주는 애너테이션
public class AppConfig {

    @Bean // 빈으로 등록해주는 애너테이션
    Car car() { // 메서드명(car)은 빈의 이름이 됨.
        return new Car();
    }

    @Bean
    @Scope("singleton") // 기본값  // getBean()호출 시, 기존의 bean 객체를 재사용함.
    Engine engine() {
        return new Engine();
    }

    @Bean
    @Scope("prototype") // getBean()호출 시, 다른 bean 객체를 사용함.
    Door door() {
        return new Door();
    }
}
*/


///////////////////////////


@Configuration
@ComponentScan
public class AppConfig {

}

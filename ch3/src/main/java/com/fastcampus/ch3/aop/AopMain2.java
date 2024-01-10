package com.fastcampus.ch3.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class AopMain2 {
    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(Config.class);
        MyMath mm = ac.getBean("myMath", MyMath.class);
        mm.add(1, 2);
        mm.add(1, 2, 3);
        System.out.println(mm.multiply(3, 5));
    }
}

//        add[1, 2]
//        3
//        0ms
//
//        add[1, 2, 3]
//        6
//        0ms
//
//        15



@EnableAspectJAutoProxy
@ComponentScan
@Configuration
class Config {

}

@Component
@Aspect
class LoggingAdvice {
    @Around("execution(* com.fastcampus.ch3.aop.MyMath.add*(..))") // "execution(접근제어자 반환타입 패키지명.클래스명.메서드명(매개변수 목록))"
    public Object methodClassLog(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println(pjp.getSignature().getName() + Arrays.toString(pjp.getArgs()));

        Object result = pjp.proceed(); // 핵심 기능 메서드 호출

        System.out.println(result);
        System.out.println((System.currentTimeMillis() - start) + "ms\n");

        return result;
    }
}

@Component
class MyMath {
    int add(int a, int b) {
        int result = a + b;
        return result;
    }

    int add(int a, int b, int c) {
        int result = a + b + c;
        return result;
    }

    int subtract(int a, int b) {
        int result = a - b;
        return result;
    }

    int multiply(int a, int b) {
        int result = a*b;
        return result;
    }

}

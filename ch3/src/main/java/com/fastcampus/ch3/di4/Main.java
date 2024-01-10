package com.fastcampus.ch3.di4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;


@Component
@Conditional(TrueCondition.class)
class Engine {
    public String toString() {
        return "Engine{}";
    }
}

@Component
@Conditional(FalseCondition.class)
class Door {
    @Override
    public String toString() {
        return "Door{}";
    }
}

@Component
@Conditional(OSCondition.class)
class Door2 {
    @Override
    public String toString() {
        return "Door{}";
    }
}



        ///////////////////////////////


class TrueCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return true;
    }
}


class FalseCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return false;
    }
}


class OSCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment env = context.getEnvironment();
        return env.getProperty("os.name").equals("windows");
    }
}








///////////////////////////////////////////////////









class Car {
    public String toString() {
        return "Car{}";
    }
}

class SportsCar1 extends Car {
    public String toString() {
        return "SportsCar1{}";
    }
}

class SportsCar2 extends Car {
    public String toString() {
        return "SportsCar2{}";
    }
}


        //////////////////////////




// @EnableMyAutoConfiguration("one")
@Import(MyImportSelector.class)
class MainConfig {
    @Bean Car car() { return new Car();}
}

class Config1 {
    @Bean Car sportsCar1() { return new SportsCar1();}
}

class Config2 {
    @Bean Car sportsCar2() { return new SportsCar2();}
}


        ///////////////////////



//@Target(ElementType.TYPE)
//@Retention(RetentionPolicy.RUNTIME)
//@Import(MyImportSelector.class)
//@interface EnableMyAutoConfiguration {
//    String value() default "";
//}



        ////////////////////////




class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {Config1.class.getName()};
    }
}


//class MyImportSelector implements ImportSelector {
//    @Override
//    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
//        AnnotationAttributes attr = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(EnableMyAutoConfiguration.class.getName(), false));
//
//        String mode = attr.getString("value");
//        if(mode.equals("one"))
//            return new String[] {Config1.class.getName()};
//        else
//            return new String[] {Config2.class.getName()};
//    }
//}





///////////////////////////////////



@EnableConfigurationProperties({MyProperties.class})
@Configuration
// @EnableAutoConfiguration
@ComponentScan
public class Main implements CommandLineRunner {
    @Autowired
    MyProperties prop;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("prop.getEmail = " + prop.getEmail()); // admin@fastcampus.com
        System.out.println("prop.getDomain() = " + prop.getDomain()); // www.fastcampus.com
    }


    public static void main(String[] args) {
        //ApplicationContext ac = SpringApplication.run(Main.class, args);
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class); // 자바 설정을 활용한 AC

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        Arrays.sort(beanDefinitionNames);
        Arrays.stream(beanDefinitionNames).filter(b->!b.startsWith("org")).forEach(System.out::println);

    }
    @Bean
    MyBean myBean() {return new MyBean();}
}

class MyBean{}

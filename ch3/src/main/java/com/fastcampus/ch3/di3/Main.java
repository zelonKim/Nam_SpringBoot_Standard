package com.fastcampus.ch3.di3;

import com.fastcampus.ch3.di3.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;

/*
class Car {
    Engine engine;
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}

class Engine {}

class Door {}
*/


//////////////////////




/*
@Component
class Car {

    Engine engine;

    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}

@Component
class Engine {}

@Component
class Door {}



public class Main {
    public static void main(String[] args) {
        // 설정 클래스를 읽은 후, ApplicationContext에 bean을 생성하여 저장함.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        Object obj = ac.getBean("car"); // 이름으로("car") 빈을 얻어옴.
        System.out.println(obj); // Car{engine=null, door=null}

        Car car = ac.getBean("car", Car.class); // 이름으로("car") 빈을 얻어온 후, 형변환(Car.class) 해줌.
        System.out.println(car); // Car{engine=null, door=null}

        ////////////////

        Object obj2 = ac.getBean(Car.class); // 타입으로(Car.class) 빈을 얻어옴.
        System.out.println(obj2); // Car{engine=null, door=null}

        Car car2 = ac.getBean(Car.class); // 타입으로(Car.class) 빈을 얻어온 후, 자동 형변환함.
        System.out.println(car2); // Car{engine=null, door=null}




        /////////////////////////////////////////


        Engine engine = ac.getBean(Engine.class);
        Engine engine2 = ac.getBean(Engine.class);
        Engine engine3 = ac.getBean(Engine.class);

        System.out.println(engine); // com.fastcampus.ch3.di3.Engine@3b35a229
        System.out.println(engine2); // com.fastcampus.ch3.di3.Engine@3b35a229
        System.out.println(engine3); // com.fastcampus.ch3.di3.Engine@3b35a229

        ///////////////

        Door door = ac.getBean(Door.class);
        Door door2 = ac.getBean(Door.class);
        Door door3 = ac.getBean(Door.class);

        System.out.println(door); // com.fastcampus.ch3.di3.Door@7dc3712
        System.out.println(door2); // com.fastcampus.ch3.di3.Door@2f67a4d3
        System.out.println(door3); // com.fastcampus.ch3.di3.Door@5e3f861


        ///////////////////////////////////


        System.out.println(ac.getBeanDefinitionCount()); // 10

        System.out.println(Arrays.toString(ac.getBeanDefinitionNames()));
        // [org.springframework.context.annotation.internalConfigurationAnnotationProcessor,
        // org.springframework.context.annotation.internalAutowiredAnnotationProcessor,
        // org.springframework.context.annotation.internalCommonAnnotationProcessor,
        // org.springframework.context.event.internalEventListenerProcessor,
        // org.springframework.context.event.internalEventListenerFactory,
        // appConfig,
        // car,
        // engine,
        // door,
        // sysInfo]

        System.out.println(ac.containsBeanDefinition("engine")); // true

        System.out.println(ac.isSingleton("engine")); // true

        System.out.println(ac.isPrototype("engine")); // false


        //////////////////////////


        SysInfo info = ac.getBean(SysInfo.class);
        System.out.println(info); // SysInfo{timeZone='Asia/Seoul', currDir='/Users/gimseongjin/IdeaProjects/ch3', autosaveDir='/auto/save', autosaveInternal=30, autosave=true}

    }
}
*/


//////////////////////////////////




/*
@Component
class Car {
//    @Autowired
//    Engine engine; // 에러 발생 (Could not autowire. There is more than one bean of 'Engine' type)

    @Autowired
    @Qualifier("superEngine")
    Engine engine; // 정상 실행

    @Autowired
    Door door;

//    @Autowired
//    public Car(Engine engine, Door door) { // 멤버변수 대신, 생성자에 @Autowired를 붙여줄 수도 있음.
//        this.engine = engine;
//        this.door = door;
//    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}


class Engine {}

@Component
class SuperEngine extends Engine {}

@Component
class TurboEngine extends Engine {}


@Component
class Door {}


public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = ac.getBean("car", Car.class);
        System.out.println(car); // Car{engine=com.fastcampus.ch3.di3.Engine@302f7971, door=com.fastcampus.ch3.di3.Door@512729ad}

    }
}
*/



//////////////////////////




@Component
class Car {
//    @Resource
//    Engine engine; // 에러 발생

    @Resource(name="superEngine")
    Engine engine; // 정상 실행

    @Resource
    Door door;


    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}


class Engine {}

@Component
class SuperEngine extends Engine {}

@Component
class TurboEngine extends Engine {}


@Component
class Door {}




public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        Car car = ac.getBean("car", Car.class);
        System.out.println(car); // Car{engine=com.fastcampus.ch3.di3.Engine@302f7971, door=com.fastcampus.ch3.di3.Door@512729ad}

    }
}






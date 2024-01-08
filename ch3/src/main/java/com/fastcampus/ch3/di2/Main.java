package com.fastcampus.ch3.di2;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

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

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}


class SportsCar extends Car{
    @Override
    public String toString() {
        return "SportsCar{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}

class Engine {}

class Door {}


public class Main {
    public static void main(String[] args) {
        AppContext ac = new AppContext(AppConfig.class);

        // 이름으로 (by Name) 객체를 찾음.
        Car car = (Car)ac.getBean("car");
        System.out.println(car); // Car{engine=null, door=null}

        Engine engine = (Engine)ac.getBean("engine");
        System.out.println(engine); // com.fastcampus.ch3.di2.Engine@51565ec2

        Door door = (Door)ac.getBean("door");
        System.out.println(door); // com.fastcampus.ch3.di2.Door@482f8f11


        ///////////////////////////


        // 타입으로 (by Type) 객체를 찾음.
        Car car2 = (Car)ac.getBean(Car.class);
        System.out.println(car2); // Car{engine=null, door=null}

        Engine engine2  = (Engine)ac.getBean(Engine.class);
        System.out.println(engine2); // com.fastcampus.ch3.di2.Engine@51565ec2

        Door door2  = (Door)ac.getBean(Door.class);
        System.out.println(door2); // com.fastcampus.ch3.di2.Door@482f8f11


        ////////////////////


        // '수동'으로 bean간의 관계를 설정해줌.
        car.setEngine(engine);
        System.out.println(car); // Car{engine=com.fastcampus.ch3.di2.Engine@51565ec2, door=null}

        car.setDoor(door);
        System.out.println(car); // Car{engine=com.fastcampus.ch3.di2.Engine@51565ec2, door=com.fastcampus.ch3.di2.Door@482f8f11}


        // '수동'으로 bean간의 관계를 설정해줌.
        car2.setEngine(engine2);
        System.out.println(car2); // Car{engine=com.fastcampus.ch3.di2.Engine@51565ec2, door=com.fastcampus.ch3.di2.Door@482f8f11}

        car2.setDoor(door2);
        System.out.println(car2); // Car{engine=com.fastcampus.ch3.di2.Engine@51565ec2, door=com.fastcampus.ch3.di2.Door@482f8f11}

    }

}
*/




////////////////////////





class Car {
    @Autowired // 타입으로 (by Type) 객체를 찾아서, '자동'으로 bean 간의 관계를 설정해줌.
    Engine engine;
    @Resource // 이름으로 (by Name) 객체를 찾아서, '자동'으로 bean 간의 관계를 설정해줌.
    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}


class SportsCar extends Car{
    @Override
    public String toString() {
        return "SportsCar{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }
}

class Engine {}

class Door {}


public class Main {
    public static void main(String[] args) {
        AppContext ac = new AppContext(AppConfig.class);

        Car car = (Car)ac.getBean("car");
        System.out.println(car); // Car{engine=com.fastcampus.ch3.di2.Engine@4b9e13df, door=com.fastcampus.ch3.di2.Door@2b98378d}

        Engine engine = (Engine)ac.getBean("engine");
        System.out.println(engine); // om.fastcampus.ch3.di2.Engine@4b9e13df

        Door door = (Door)ac.getBean("door");
        System.out.println(door); // com.fastcampus.ch3.di2.Door@2b98378d


        ///////////////////////////


        Car car2 = (Car)ac.getBean(Car.class);
        System.out.println(car2); // Car{engine=com.fastcampus.ch3.di2.Engine@4b9e13df, door=com.fastcampus.ch3.di2.Door@2b98378d}

        Engine engine2  = (Engine)ac.getBean(Engine.class);
        System.out.println(engine2); // com.fastcampus.ch3.di2.Engine@4b9e13df

        Door door2  = (Door)ac.getBean(Door.class);
        System.out.println(door2); // com.fastcampus.ch3.di2.Door@2b98378d



    }

}
package com.fastcampus.ch3.di1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Car {
    @Autowired
    Engine engine;

    Door door;

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", door=" + door +
                '}';
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }
}


class SportsCar extends Car {}
class Truck extends Car {}

class Engine {}
class Door {}




public class main {
    public static void main(String[] args) throws Exception{
//         SportsCar car1 = new SportsCar();
//         Truck car2 = new Truck();


            // 다형성 활용
//         Car car1 = new SportsCar();
//         Car car2 = new Truck();


            // 추상화 활용
//            Car car = getCar();



        // 의존성 주입 활용
        Car car = (Car)getObject("car");
        Engine engine = (Engine)getObject("engine");
        Door door = (Door)getObject("door");

        System.out.println(car); // com.fastcampus.ch3.di1.SportsCar@73f792cf
        System.out.println(engine); // com.fastcampus.ch3.di1.Engine@2ed94a8b
        System.out.println(door); // com.fastcampus.ch3.di1.Door@38082d64
    }


//    static Car getCar() {
//        return new Truck();
//        return new SportsCar();
//    }


    static Object getObject(String key) throws Exception {
//        if(key.equals("car")) return new SportsCar();
//        else if(key.equals("engine")) return new Engine();
//        else if(key.equals("door")) return new Door();


        Properties prop = new Properties();
        Class clazz = null;

        prop.load(new FileReader("config.txt"));
        String className = prop.getProperty(key); // 지정한 key의 value를 반환함.
        clazz = Class.forName(className); // 지정한 클래스명(className)에 해당하는 클래스 객체를 얻어옴.

        return clazz.newInstance();
    }


}










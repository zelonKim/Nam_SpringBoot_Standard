package com.fastcampus.ch3.di1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        System.out.println(car); // Car{engine=null, door=null}

        Class carClass = car.getClass(); // 객체명.getClass()를 통해 Class객체를 얻어옴.
        carClass = Car.class; // 클래스명.class를 통해 Class객체를 얻어옴.
        carClass = Class.forName("com.fastcampus.ch3.di1.Car"); // Class.forName("패키지명.클래스명")을 통해 Class객체를 얻어옴.


        Car car2 = (Car)carClass.newInstance(); // Class객체.newInstance()를 통해 객체를 생성함.
        System.out.println(car2); // Car{engine=null, door=null}



        Field[] mvArr = carClass.getDeclaredFields(); // Class객체.getDeclaredFields()를 통해 클래스에 선언된 필드 객체배열을 가져옴.

        for(Field mv: mvArr) {
            System.out.println(mv);
                // com.fastcampus.ch3.di1.Engine  com.fastcampus.ch3.di1.Car.engine
                // com.fastcampus.ch3.di1.Door  com.fastcampus.ch3.di1.Car.door

            System.out.println(mv.getName()); // engine  door

            String methodName = "set" + StringUtils.capitalize(mv.getName()); // 앞글자만 대문자로 변환함.
            System.out.println(methodName); // setEngine  setDoor

            Method method = carClass.getMethod(methodName, mv.getType());  // Class객체.getMethod("메서드명", 매개변수 타입)을 통해 해당 메서드 객체를 얻어옴.
            method.invoke(car, mv.getType().newInstance());  // 메서드 객체.invoke(객체명, 인수)를 통해 해당 메서드를 실행함.
            System.out.println(car);
                // Car{engine=com.fastcampus.ch3.di1.Engine@531be3c5, door=null}
                // Car{engine=com.fastcampus.ch3.di1.Engine@531be3c5, door=com.fastcampus.ch3.di1.Door@21af6cff}


            Annotation[] annoArr = mv.getDeclaredAnnotations(); // 필드객체.getDeclaredAnnotations()을 통해 필드에 선언된 애너테이션 객체배열을 가져옴.
            System.out.println(annoArr);
                // [Ljava.lang.annotation.Annotation;@d2cc05a
                // [Ljava.lang.annotation.Annotation;@548a9f61

            for(Annotation anno : annoArr) {
                System.out.println(anno.annotationType()); // interface org.springframework.beans.factory.annotation.Autowired
                System.out.println(anno.annotationType().getSimpleName()); // Autowired

                if(anno.annotationType()==Autowired.class) {
                    System.out.println(car); // Car{engine=com.fastcampus.ch3.di1.Engine@531be3c5, door=null}
                }
            }

        }


/*
        Method[] methodArr = carClass.getDeclaredMethods(); // Class객체.getDeclaredMethods()를 통해 클래스에 선언된 메서드 객체배열을 가져옴.
        for(Method method: methodArr) {
            System.out.println(method);
                // public java.lang.String com.fastcampus.ch3.di1.Car.toString()
                // public com.fastcampus.ch3.di1.Engine com.fastcampus.ch3.di1.Car.getEngine()
                // public void com.fastcampus.ch3.di1.Car.setEngine(com.fastcampus.ch3.di1.Engine)
                // public com.fastcampus.ch3.di1.Door com.fastcampus.ch3.di1.Car.getDoor()
                // public void com.fastcampus.ch3.di1.Car.setDoor(com.fastcampus.ch3.di1.Door)

            System.out.println(method.getName()); // toString  getEngine  setEngine  getDoor  setDoor
        }
*/


        Method method = carClass.getMethod("setEngine", Engine.class);  // Class객체.getMethod("메서드명", 매개변수 타입)을 통해 해당 메서드 객체를 얻어옴.
        // System.out.println(method); // public void com.fastcampus.ch3.di1.Car.setEngine(com.fastcampus.ch3.di1.Engine)

        method.invoke(car2, new Engine());  // 메서드 객체.invoke(객체명, 인수)를 통해 해당 메서드를 실행함.
        System.out.println(car2); // Car{engine=com.fastcampus.ch3.di1.Engine@8df97b55, door=null}


    }
}

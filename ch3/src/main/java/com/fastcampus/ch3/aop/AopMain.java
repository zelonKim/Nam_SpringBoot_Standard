package com.fastcampus.ch3.aop;

import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AopMain {
    public static void main(String[] args) throws Exception {
        Class myClass = Class.forName("com.fastcampus.ch3.aop.MyClass");
        Object obj = myClass.newInstance();

        MyAdvice myAdvice = new MyAdvice();

        for(Method m: myClass.getDeclaredMethods()) {
            myAdvice.invoke(m, obj, null);
        }
    }
}

//    before
//    aaa() is called
//    after
//
//    bbb() is called
//    ccc() is called






class MyAdvice {
    Pattern p = Pattern.compile("a.*");

    boolean matches(Method m) {
        Matcher matcher = p.matcher(m.getName());
        return matcher.matches();
    }

    void invoke(Method m, Object obj, Object... args) throws Exception {
        if(matches(m)) System.out.println("before");  // 메서드명이 a로 시작하는 경우에만 "before"를 출력함.
            m.invoke(obj, args); // aaa(), bbb(), ccc() 호출
        if(m.getAnnotation(Transactional.class)!=null) System.out.println("after\n"); // @Transactional이 붙은 경우에만 "after'를 출력함.
    }
}


class MyClass {
    @Transactional
    void aaa() {
        System.out.println("aaa() is called");
    }

    void bbb() {
        System.out.println("bbb() is called");
    }

    void ccc() {
        System.out.println("ccc() is called");
    }
}




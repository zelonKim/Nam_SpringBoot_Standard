package com.fastcampus.ch2;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamTest {

    @RequestMapping("/requestParam1")
    public String main1(String year) { // 선택값
        // 기본형 매개변수에는 @RequestParam(required=false)가 자동으로 붙음.
        System.out.println(year); // null
        return "this Year"; // 정상 실행
    }

    @RequestMapping("/requestParam2")
    public String main2(@RequestParam String year) { // 필수값
        System.out.println(year); // ""
        return "this Year";  // 에러 발생 (400 Bad Request)
    }




    @RequestMapping("/requestParam3")
    public String main3(@RequestParam(required=false) String year) { // 선택값
        System.out.println(year); // null
        return "this Year";  // 정상 실행
    }

    @RequestMapping("/requestParam4")
    public String main4(@RequestParam(required=false, defaultValue="1") String year) { // 선택값, 기본값 1
        System.out.println(year); // 1
        return "this Year"; // 정상 실행
    }

}
















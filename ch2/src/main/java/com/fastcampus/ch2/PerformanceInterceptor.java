package com.fastcampus.ch2;


import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component // ApplicationContext의 bean으로 등록함.
public class PerformanceInterceptor implements HandlerInterceptor {  // 인터셉터는 HandlerInterceptor를 구현해야 함.

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1. 전처리 작업
        long startTime = System.currentTimeMillis();
        request.setAttribute("StartTime", startTime); // request 객체에 해당 속성을 저장함.

        HandlerMethod hm = (HandlerMethod) handler; // handler는 해당 요청 정보를 담고 있는 객체임.
        System.out.println(hm.getMethod()); // 해당 요청과 연결된 메서드 정보   // public java.lang.String com.fastcampus.ch2.HomeController.main()
        System.out.println(hm.getBean()); // 해당 요청과 연결된 클래스 객체 정보   // com.fastcampus.ch2.HomeController@3babfb4b

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 2. 후처리 작업
        long startTime = (long)request.getAttribute("StartTime"); // request 객체에서 해당 속성값을 가져옴.
        long endTime = System.currentTimeMillis();
        System.out.print(((javax.servlet.http.HttpServletRequest)request).getRequestURI() + "작업은 ");
        System.out.println(endTime - startTime + "밀리초가 소요되었습니다.");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

}


package com.fastcampus.ch2;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns="/*") // @WebFilter(urlPatterns="필터를 적용할 URL")
public class PerformanceFilter implements Filter { // 필터는 Filter 인터페이스를 구현해야 함.

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain fc) throws IOException, ServletException {
        // 1. 전처리 작업
        long startTime = System.currentTimeMillis();

        // 2. 서블릿 호출
        fc.doFilter(request, response);

        // 3. 후처리 작업
        long endTime = System.currentTimeMillis();
        System.out.print(((HttpServletRequest)request).getRequestURI() + "작업은 ");
        System.out.println(endTime - startTime + "밀리초가 소요되었습니다.");

    }

}


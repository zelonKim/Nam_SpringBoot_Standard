package com.fastcampus.ch2;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 인터셉터를 설정함.
public class WebMvcConfig implements WebMvcConfigurer { // 인터셉터 설정 클래스는 WebMvcConfigurer를 구현해야 함.

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PerformanceInterceptor()) // 인터셉터를 등록해줌.
        .addPathPatterns("/**") // 인터셉터를 적용할 파일 경로
                .excludePathPatterns("/css/**", "/js/**"); // 인터셉터를 제외할 파일 경로

    }
}

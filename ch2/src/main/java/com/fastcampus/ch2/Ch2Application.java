
package com.fastcampus.ch2;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Ch2Application { // 서블릿에 필터를 적용하기 위해 @ServletComponentScan을 붙여줌.
    public static void main(String[] args) {
        SpringApplication.run(Ch2Application.class, args);
    }

}
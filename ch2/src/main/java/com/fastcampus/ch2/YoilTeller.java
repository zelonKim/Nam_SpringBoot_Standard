package com.fastcampus.ch2;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;


/*
@Controller
public class YoilTeller {

    @RequestMapping("/getYoil")
    public void main(HttpServletRequest request, HttpServletResponse response) throws IOException {


        // 관심사1. 입력  -> DS 활용
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);




        // 관심사2. 처리  -> Controller로 분리
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month-1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);

        // 처리결과를 Model에 담아서 뷰에 전달함.



        // 관심사3. 출력   ->  View로 분리
        response.setCharacterEncoding("ms949");

        PrintWriter outStm = response.getWriter();
        outStm.println("<html>");
        outStm.println("<head>");
        outStm.println("</head>");
        outStm.println("<body>");
        outStm.println(year+"년 "+month+"월 "+day+"일은 "+yoil+"요일 입니다.");
        outStm.println("</body>");
        outStm.println("</html>");

    }

}

*/




/////////////////////////////////




@Controller
public class YoilTeller {

    @RequestMapping("/getYoil")
    public String main(int year, int month, int day, Model m) throws IOException {

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month-1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);

        // 처리 결과를 Model에 담아주면 DS가 자동으로 모델에 담긴 데이터를 뷰로 전달해줌.
        m.addAttribute("Year", year);
        m.addAttribute("Month", month);
        m.addAttribute("Day", day);
        m.addAttribute("Yoil", yoil);

        return "yoil";  // yoil.html 뷰를 반환함.
    }
}


















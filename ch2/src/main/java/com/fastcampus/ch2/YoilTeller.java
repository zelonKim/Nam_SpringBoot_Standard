package com.fastcampus.ch2;




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


/*


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
*/





///////////////////////






/*

@Controller
public class YoilTeller {

    @RequestMapping("/yoil")
    public ModelAndView main(int year, int month, int day) throws IOException { // Model 매개변수 사용 x
        ModelAndView mv = new ModelAndView(); // ModelAndView 객체 생성

        mv.setViewName("yoilError"); // 기본 뷰 지정

        if (!isValid(year, month, day)) {
            return mv; // 기본 뷰 반환
        }

        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek - 1);


        mv.addObject("Year", year); // 처리 결과를 ModelAndView에 담아줌.
        mv.addObject("Month", month);
        mv.addObject("Day", day);
        mv.addObject("Yoil", yoil);
        mv.setViewName("yoil"); // 다른 뷰 지정

        return mv; // 다른 뷰 반환
    }

        private boolean isValid (int year, int month, int day) {
            return true;
        }

    }
    */




//////////////////////////////


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Calendar;

@Controller
public class YoilTeller {

    @RequestMapping("/getYoil")
    public String main(@ModelAttribute("myDate") MyDate myDate, Model m) throws IOException {
        // @ModelAttribute("속성명")를 '참조형 매개변수 타입' 앞에 붙여주면, 자동으로 해당 '매개변수 객체'를 속성값으로 하여 Model에 담아줌.

    // public String main(MyDate myDate, Model m) throws IOException { // 참조형 매개변수에는 @ModelAttribute가 자동으로 붙음.
        getYoil(myDate);

        return "yoil";
    }

    @ModelAttribute("Yoil")  // @ModelAttribute("속성명")를 '메서드' 앞에 붙여주면, 자동으로 해당 '반환값'을 속성값으로 하여 Model에 담아줌.
    private static char getYoil(MyDate myDate) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(myDate.getYear(), myDate.getMonth()-1, myDate.getDay());

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char yoil = "일월화수목금토".charAt(dayOfWeek-1);
        return yoil;
    }

}


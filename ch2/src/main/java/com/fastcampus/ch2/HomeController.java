package com.fastcampus.ch2;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/leaf")
    public String leaf(Model m, HttpServletRequest request)
    {
        request.setAttribute("year", 2024);

        HttpSession session = request.getSession();
        session.setAttribute("id", "asdf");

        ServletContext application = session.getServletContext();
        application.setAttribute("email", "ksz1860@fastcampus.com");



        m.addAttribute("lastName", "kim");
        m.addAttribute("firstName", "seongjin");
        m.addAttribute("list", Arrays.asList("aaa", "bbb","ccc","ddd","eee"));
        m.addAttribute("bno", 123);
        m.addAttribute("user", new User("aaa",20));
        return "leaf";
    }
}

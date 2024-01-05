package com.fastcampus.ch2;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String main() {
        return "index";
    }

    @GetMapping("/test")
    public String test(Model m)
    {
        m.addAttribute("lastName", "kim");
        m.addAttribute("firstName", "seongjin");
        m.addAttribute("list", Arrays.asList("aaa", "bbb","ccc","ddd","eee"));
        return "leaf";
    }
}

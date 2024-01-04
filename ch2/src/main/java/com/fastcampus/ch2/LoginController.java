package com.fastcampus.ch2;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@RequestMapping("/login") // 공통적으로 맵핑될 URI
public class LoginController {
    @GetMapping("/login") // GET login/login
    public String showLogin() {
        return "login";
    }

    @PostMapping("/login") // POST login/login
    public String login(String id, String pwd, Model m) throws Exception {

        if(loginCheck(id, pwd)) {
            m.addAttribute("Id", id);
            m.addAttribute("Pwd", pwd);
            return "userInfo";
        } else {
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
            return "redirect:/login/login?msg=" + msg; // redirect는 Get 요청을 수행함.
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }

}

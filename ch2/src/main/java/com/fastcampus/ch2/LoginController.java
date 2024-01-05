package com.fastcampus.ch2;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;


/*
@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }


    @PostMapping("/login")
    public String login(String id, String pwd, Model m, RedirectAttributes ra, HttpServletRequest req) throws Exception {

        if(loginCheck(id, pwd)) {
            m.addAttribute("Id", id);
            m.addAttribute("Pwd", pwd);
            return "userInfo";
        } else {
            String msg = "id 또는 pwd가 일치하지 않습니다.";
            // ra.addAttribute("msg", msg);
            ra.addFlashAttribute("msg", msg);

            return "redirect:/login/login";
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }
}
*/



/////////////////////////////





@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }


    @PostMapping("/login")
    public String login(String id, String pwd,HttpServletRequest req) throws Exception {

        if(loginCheck(id, pwd)) {
            req.setAttribute("Id", id);
            req.setAttribute("Pwd", pwd);
            return "userInfo";
        } else {
            String msg = "id 또는 pwd가 일치하지 않습니다.";
            req.setAttribute("msg", msg);
            return "forward:/";
        }
    }

    private boolean loginCheck(String id, String pwd) {
        return id.equals("asdf") && pwd.equals("1234");
    }

}

















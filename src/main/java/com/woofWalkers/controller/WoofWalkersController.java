package com.woofWalkers.controller;


import com.woofWalkers.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WoofWalkersController {

    @GetMapping("/")
    public String root() {
        return "login";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

//    @GetMapping("/profile")
//   public String profile() {return "profile";}

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "logout";
    }

    @GetMapping("/termsAndConditions")
    public String termsAndConditions(Model model) {
        return "termsAndConditions";
    }

}

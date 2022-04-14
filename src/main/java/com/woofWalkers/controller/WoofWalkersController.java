package com.woofWalkers.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class WoofWalkersController {
    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

}

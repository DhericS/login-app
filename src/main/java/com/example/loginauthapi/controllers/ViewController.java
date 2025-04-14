package com.example.loginauthapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String login() {
        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }


    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}

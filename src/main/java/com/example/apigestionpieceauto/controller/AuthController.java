package com.example.apigestionpieceauto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @GetMapping("/register")
    public String register() {
        return "auth/register";  // correspond à templates/auth/register.html
    }

    // tu peux garder aussi le login
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}

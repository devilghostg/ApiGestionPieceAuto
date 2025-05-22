package com.example.apigestionpieceauto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/register")
    public String register() {
        return "auth/register";  // regarde bien le nom ici
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}


package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.UserEntity;
import com.example.apigestionpieceauto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "auth/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity user, Model model) {
        try {

            if (userService.findByUsername(user.getUsername()) != null) {
                model.addAttribute("error", "Ce nom d'utilisateur existe déjà");
                return "auth/register";
            }
            

            user.setRole("USER");
            userService.save(user);
            return "redirect:/login?registered=true";
        } catch (Exception e) {
            model.addAttribute("error", "Erreur lors de l'inscription");
            return "auth/register";
        }
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
}
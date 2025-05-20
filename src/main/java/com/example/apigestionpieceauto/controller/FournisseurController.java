package com.example.apigestionpieceauto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {
    @GetMapping
    public String getFournisseur() {

        return "fournisseur/index";
    }

    
    @GetMapping("/all")
    public String getFournisseurAll() {
        return "fournisseur/all";
    }

    @GetMapping("/aluminium")
    public String getFournisseurAluminium() {
        return "fournisseur/aluminium";
    }

    @GetMapping("/bois")
    public String getFournisseurBois() {
        return "fournisseur/bois";
    }

}

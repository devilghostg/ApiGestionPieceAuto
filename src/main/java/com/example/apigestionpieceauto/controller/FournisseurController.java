package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.Fournisseur;
import com.example.apigestionpieceauto.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

    @Autowired
    private FournisseurRepository fournisseurRepository;

    @GetMapping
    public String getFournisseur(Model model) {
        model.addAttribute("fournisseurs", fournisseurRepository.findAll());
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

    @PostMapping("/add")
    public String addFournisseur(Fournisseur fournisseur) {
        fournisseurRepository.save(fournisseur);
        return "redirect:/fournisseur";
    }
}

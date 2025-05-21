package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.Fournisseur;
import com.example.apigestionpieceauto.repository.FournisseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;

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
    @GetMapping("/show/{id}")
    public String showFournisseur(@PathVariable Long id, Model model) {
        var fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé"));
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseur/show";
    }

    @GetMapping("/edit/{id}")
    public String editFournisseur(@PathVariable Long id, Model model) {
        var fournisseur = fournisseurRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé"));
        model.addAttribute("fournisseur", fournisseur);
        return "fournisseur/edit";
    }


    @PostMapping("/edit/{id}")
    public String updateFournisseur(@PathVariable Long id, @ModelAttribute Fournisseur fournisseur) {
        try {
            var fournisseurToUpdate = fournisseurRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Fournisseur non trouvé"));
            
            fournisseurToUpdate.setNom(fournisseur.getNom());
            fournisseurToUpdate.setAdresse(fournisseur.getAdresse());
            fournisseurToUpdate.setTelephone(fournisseur.getTelephone());
            
            fournisseurRepository.save(fournisseurToUpdate);
            
            return "redirect:/fournisseur/show/" + id;
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }
    }
}

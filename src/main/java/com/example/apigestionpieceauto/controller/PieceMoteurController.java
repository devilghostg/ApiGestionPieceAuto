package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.PieceMoteur;
import com.example.apigestionpieceauto.Entity.TypeMoteur;
import com.example.apigestionpieceauto.service.FournisseurService;
import com.example.apigestionpieceauto.service.PieceMoteurService;
import com.example.apigestionpieceauto.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/piece/moteur")
class PieceMoteurController {

    @Autowired
    private PieceMoteurService pieceMoteurService;

    @Autowired
    private FournisseurService fournisseurService;

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping
    public String pieceMoteurs(Model model) {
        model.addAttribute("moteurs", pieceMoteurService.findAllPieceMoteurs());
        return "pieces/moteur/index";
    }

    @GetMapping("/{id}")
    public String pieceMoteur(@PathVariable Long id, Model model) {
        model.addAttribute("moteur", pieceMoteurService.findPieceMoteurById(id).orElseThrow(() -> new RuntimeException("Le moteur n'existe pas")));
        return "pieces/moteur/show";
    }

    @GetMapping("/new")
    public String newPieceMoteur(Model model) {

        model.addAttribute("typeMoteurs", TypeMoteur.values());
        model.addAttribute("fournisseurs", fournisseurService.getAllFournisseur());
        model.addAttribute("vehicules", vehiculeService.findAllVehicules());
        return "pieces/moteur/new";
    }

    @GetMapping("/edit/{id}")
    public String editPieceMoteur(@PathVariable Long id, Model model) {
        model.addAttribute("moteur", pieceMoteurService.findPieceMoteurById(id).orElseThrow(() -> new RuntimeException("Le moteur n'existe pas")));
        model.addAttribute("typeMoteurs", TypeMoteur.values());
        model.addAttribute("fournisseurs", fournisseurService.getAllFournisseur());
        model.addAttribute("vehicules", vehiculeService.findAllVehicules());
        return "pieces/moteur/edit";
    }

    @PostMapping("/new")
    public String createPieceMoteur(@ModelAttribute PieceMoteur pieceMoteur) {
        pieceMoteurService.createPieceMoteur(pieceMoteur);
        return "redirect:/piece/moteur";
    }

    /**
     * Ajouté la fonctionnalité de update dans le Service
     * @param id
     * @param pieceMoteur
     * @return redirect:piece/moteur/id
     */
    @PostMapping("/edit/{id}")
    public String updatePieceAuto(@PathVariable Long id, @ModelAttribute PieceMoteur pieceMoteur) {
        System.out.println("TypeMoteur " + pieceMoteur.getTypeMoteur());

        pieceMoteurService.createPieceMoteur(pieceMoteur);
        return "redirect:/piece/moteur/" + id;
    }

    /**
     * @param id Id de l'élement à supprimer
     * @return redirect vers la page à l'addresse {@link "http://server.name:8080/piece/moteur"}
     */
    @PostMapping("/delete/{id}")
    public String deletePieceMoteur(@PathVariable Long id) {
        pieceMoteurService.deletePieceMoteur(id);
        return "redirect:/piece/moteur";
    }

}

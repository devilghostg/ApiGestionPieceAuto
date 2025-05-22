package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.Vehicule;
import com.example.apigestionpieceauto.repository.VehiculeRepository;
import com.example.apigestionpieceauto.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.Optional;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vehicule")
class VehiculeController {

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping
    public String getAllVehicules(Model model) {
        model.addAttribute("vehicules", vehiculeService.findAllVehicules());
        return "vehicule/index";
    }

    @GetMapping("/new")
    public String newVehicule(Model model) {
        model.addAttribute("vehicule", new Vehicule());
        return "vehicule/new";
    }


    @PostMapping
    public String saveVehicule(@ModelAttribute Vehicule vehicule) {
        vehiculeService.createVehicule(vehicule);
        return "redirect:/vehicule";
    }


    @GetMapping("/{id}")
    public String getVehiculeById(@PathVariable Long id, Model model) {
        Optional<Vehicule> optionalVehicule = vehiculeService.findVehiculeById(id);
        if (optionalVehicule.isPresent()) {
            model.addAttribute("vehicule", optionalVehicule.get());
            return "vehicule/show";
        } else {
            return "redirect:/vehicule"; 
        }
    }

    @GetMapping("/edit/{id}")
    public String editVehicule(@PathVariable Long id, Model model) {
        Optional<Vehicule> optionalVehicule = vehiculeService.findVehiculeById(id);
        if (optionalVehicule.isPresent()) {
            model.addAttribute("vehicule", optionalVehicule.get());
            return "vehicule/edit";
        } else {
            return "redirect:/vehicule";
        }
    }

    @PostMapping("/new")
    public String sendVehicule(@ModelAttribute Vehicule vehicule) {
        vehiculeService.createVehicule(vehicule);
        return "redirect:/vehicule";
    }

    @PostMapping("/edit/{id}")
    public String updateVehicule(@ModelAttribute Vehicule vehicule, @PathVariable Long id) {
        vehiculeService.updateVehicule(id, vehicule);
        return "redirect:/vehicule";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
        return "redirect:/vehicule";
    }

}

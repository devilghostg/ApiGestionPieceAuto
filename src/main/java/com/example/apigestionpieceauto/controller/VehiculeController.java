package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.Vehicule;
import com.example.apigestionpieceauto.repository.VehiculeRepository;
import com.example.apigestionpieceauto.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/{id}")
    public String getVehiculeById(@PathVariable Long id, Model model) {
        model.addAttribute("vehicule", vehiculeService.findVehiculeById(id));
        return "vehicule/show";
    }

    @GetMapping("/new")
    public String newVehicule() {
        return "vehicule/new";
    }

    @GetMapping("/edit/{id}")
    public String editVehicule(@PathVariable Long id, Model model) {
        model.addAttribute("vehicule", vehiculeService.findVehiculeById(id));
        return "pieces/moteur/edit";
    }

    @PostMapping("/new/send")
    public String sendVehicule(@ModelAttribute Vehicule vehicule) {
        vehiculeService.createVehicule(vehicule);
        return "redirect:/vehicule";
    }

    /**
     * Ajouté la fonctionnalité de update dans le Service
     * @param vehicule
     * @param id
     * @return
     */
    @PutMapping("/edit/{id}/send")
    public String updateVehicule(@ModelAttribute Vehicule vehicule, @PathVariable Long id) {
        vehiculeService.createVehicule(vehicule);
        return "redirect:/vehicule";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVehicule(@PathVariable Long id) {
        vehiculeService.deleteVehicule(id);
        return "redirect:/vehicule";
    }

}

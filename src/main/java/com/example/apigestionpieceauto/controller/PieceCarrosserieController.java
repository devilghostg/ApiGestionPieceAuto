package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.PieceAuto;
import com.example.apigestionpieceauto.Entity.PieceCarrosserie;
import com.example.apigestionpieceauto.Entity.PieceMoteur;
import com.example.apigestionpieceauto.Entity.TypeCarrosserie;
import com.example.apigestionpieceauto.service.FournisseurService;
import com.example.apigestionpieceauto.service.PieceCarrosserieService;
import com.example.apigestionpieceauto.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/piece/carrosserie")
class PieceCarrosserieController {

    @Autowired
    private PieceCarrosserieService pieceCarrosserieService;

    @Autowired
    private FournisseurService fournisseurService;

    @Autowired
    private VehiculeService vehiculeService;

    @GetMapping
    public String getPieceCarrosseries(Model model) {
        model.addAttribute("pieceCarrosseries", pieceCarrosserieService.getAllPieceCarrosseries());
        return "pieces/carrosserie/index";
    }

    @GetMapping("/{id}")
    public String getPieceCarrosserieById(@PathVariable Long id, Model model) {

        System.out.println("Type carrosserie: " + pieceCarrosserieService.getPieceCarrosserieById(id).get().getTypeCarrosserie());

        model.addAttribute("carrosserie", pieceCarrosserieService.getPieceCarrosserieById(id).orElseThrow(()-> new RuntimeException("Carrosserie not found")));
        return "pieces/carrosserie/show";
    }

    @GetMapping("/new")
    public String newPieceCarrosserie(Model model) {
        model.addAttribute("typeCarrosserie", TypeCarrosserie.values());
        model.addAttribute("fournisseurs", fournisseurService.getAllFournisseur());
        model.addAttribute("vehicules", vehiculeService.findAllVehicules());
        return "pieces/carrosserie/new";
    }

    @GetMapping("/edit/{id}")
    public String editPieceCarrosserie(@PathVariable Long id, Model model) {
        model.addAttribute("carrosserie", pieceCarrosserieService.getPieceCarrosserieById(id).orElseThrow(()-> new RuntimeException("Carrosserie not found")));
        model.addAttribute("typeCarrosserie", TypeCarrosserie.values());
        model.addAttribute("fournisseurs", fournisseurService.getAllFournisseur());
        model.addAttribute("vehicules", vehiculeService.findAllVehicules());
        return "pieces/carrosserie/edit";
    }

    @GetMapping("/type/{typeCarrosserie}")
    public String getTypeCarrosserie(@PathVariable TypeCarrosserie typeCarrosserie, Model model) {
        model.addAttribute("typeCarrosserie", pieceCarrosserieService.getAllByTypeCarrosserie(typeCarrosserie));
        return "pieces/carrosserie/typeCarrosserie";
    }

    /*@GetMapping("/aluminium")
    public ResponseEntity<List<PieceCarrosserie>> aluminium() {
        return new ResponseEntity<>(pieceCarrosserieRepository.findPieceCarrosserieByTypeCarrosserie(TypeCarrosserie.ALUMINIUM), HttpStatus.OK);
    }*/

    @PostMapping("/new")
    public String createPieceCarrosserie(PieceCarrosserie pieceCarrosserie) {
        pieceCarrosserieService.createPieceCarrosserie(pieceCarrosserie);
        return "redirect:/piece/carrosserie";
    }

    /**
     * Ajouté la fonctionnalité de update dans le Service
     * @param id
     * @param pieceCarrosserie
     * @return redirect:piece/carrosserie/id
     */
    @PostMapping("/edit/{id}")
    public String updatePieceCarrosserie(@PathVariable Long id, @ModelAttribute PieceCarrosserie pieceCarrosserie) {
        pieceCarrosserieService.updatePieceCarrosserie(pieceCarrosserie);
        return "redirect:/piece/carrosserie/" + id;
    }

    /**
     * @param id Id de l'élement à supprimer
     * @return redirect vers la page à l'addresse {@link "http://server.name:8080/piece/carrosserie"}
     */
    @PostMapping("/delete/{id}")
    public String deletePieceCarrosserie(@PathVariable Long id) {
        pieceCarrosserieService.deletePieceCarrosserie(id);
        return "redirect:/piece/carrosserie";
    }

}

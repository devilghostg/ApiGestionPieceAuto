package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.PieceAuto;
import com.example.apigestionpieceauto.service.PieceAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.apigestionpieceauto.service.FournisseurService;

import java.util.Optional;

@Controller
@RequestMapping("/piece")
class PieceAutoController {

    @Autowired
    private PieceAutoService pieceAutoService;

    @Autowired
    private FournisseurService fournisseurService;

    @GetMapping
    public String pieceAuto(Model model) {
        model.addAttribute("pieceAutos", pieceAutoService.getAllPieceAuto());
        return "pieces/index";
    }

    @GetMapping("/{id}")
    public String pieceAuto(@PathVariable Long id, Model model) {
        model.addAttribute("pieceAutos", pieceAutoService.getPieceAutoById(id));
        return "pieces/show";
    }

    @GetMapping("/new")
    public String addPieceAuto(Model model) {
        model.addAttribute("fournisseurs", fournisseurService.getAllFournisseur());
        return "pieces/new";
    }

    @GetMapping("/edit/{id}")
    public String editPieceAuto(@PathVariable Long id, Model model) {
        Optional<PieceAuto> pieceAuto = pieceAutoService.getPieceAutoById(id);
        if (pieceAuto.isPresent()) {
            model.addAttribute("pieceAuto", pieceAuto.get());
            model.addAttribute("fournisseurs", fournisseurService.getAllFournisseur());
            return "pieces/edit";
        }
        return "redirect:/piece";
    }

    @PostMapping("/add")
    public String createPieceAuto(@ModelAttribute PieceAuto pieceAuto) {
        pieceAutoService.createPieceAuto(pieceAuto);
        return "redirect:/piece";
    }

    @PostMapping("/edit/{id}/send")
    public String updatePieceAuto(@PathVariable Long id, @ModelAttribute PieceAuto pieceAuto) {
        pieceAutoService.updatePieceAuto(id, pieceAuto);
        return "redirect:/piece/show/" + id;
    }

    @DeleteMapping("/delete/{id}")
    public String deletePieceAuto(@PathVariable Long id) {
        pieceAutoService.deletePieceAutoById(id);
        return "redirect:/piece";
    }

    @GetMapping("/show/{id}")
    public String showPieceAuto(@PathVariable Long id, Model model) {
        Optional<PieceAuto> pieceAuto = pieceAutoService.getPieceAutoById(id);
        if (pieceAuto.isPresent()) {
            PieceAuto piece = pieceAuto.get();
            model.addAttribute("pieceAuto", piece);
            model.addAttribute("fournisseur", piece.getFournisseur());
            return "pieces/show";
        }
        return "redirect:/piece";
    }

}

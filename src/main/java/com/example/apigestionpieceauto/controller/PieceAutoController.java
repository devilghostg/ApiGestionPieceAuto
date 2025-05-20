package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.PieceAuto;
import com.example.apigestionpieceauto.service.PieceAutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/piece")
class PieceAutoController {

    @Autowired
    private PieceAutoService pieceAutoService;

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
    public String addPieceAuto() {
        return "pieces/new";
    }

    @GetMapping("/edit/{id}")
    public String editPieceAuto(@PathVariable Long id, Model model) {
        model.addAttribute("id", pieceAutoService.getPieceAutoById(id));
        return "pieces/edit";
    }

    @PostMapping("/add")
    public String createPieceAuto(@ModelAttribute("pieceAutos") PieceAuto pieceAuto) {
        pieceAutoService.createPieceAuto(pieceAuto);
        return "redirect:/pieceauto";
    }

    @PutMapping("/edit/{id}/send")
    public String updatePieceAuto(@PathVariable Long id, @ModelAttribute PieceAuto pieceAuto) {
        return "redirect:/pieceauto/" + id;
    }

}

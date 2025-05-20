package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.Entity.PieceCarrosserie;
import com.example.apigestionpieceauto.Entity.TypeCarrosserie;
import com.example.apigestionpieceauto.service.PieceCarrosserieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/piece/carrosserie")
class PieceCarrosserieController {

    @Autowired
    private PieceCarrosserieService pieceCarrosserieService;

    @GetMapping
    public String getPieceCarrosserie(Model model) {
        model.addAttribute("pieceCarrosserie", pieceCarrosserieService.getAllPieceCarrosseries());
        return "piece/carrosserie/index";
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
}

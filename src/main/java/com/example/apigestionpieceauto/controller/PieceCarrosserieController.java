package com.example.apigestionpieceauto.controller;

import com.example.apigestionpieceauto.model.PieceCarrosserie;
import com.example.apigestionpieceauto.model.TypeCarrosserie;
import com.example.apigestionpieceauto.repository.PieceCarrosserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class PieceCarrosserieController {

    @Autowired
    private PieceCarrosserieRepository pieceCarrosserieRepository;

    @GetMapping("/piececarrosserrie/aluminium")
    public ResponseEntity<List<PieceCarrosserie>> aluminium() {
        return new ResponseEntity<>(pieceCarrosserieRepository.findPieceCarrosserieByTypeCarrosserie(TypeCarrosserie.ALUMINIUM), HttpStatus.OK);
    }
}

package com.example.apigestionpieceauto.service;

import com.example.apigestionpieceauto.Entity.PieceCarrosserie;
import com.example.apigestionpieceauto.Entity.TypeCarrosserie;
import com.example.apigestionpieceauto.repository.PieceCarrosserieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PieceCarrosserieService {

    @Autowired
    private PieceCarrosserieRepository pieceCarrosserieRepository;

    @Autowired
    public PieceCarrosserieService(PieceCarrosserieRepository pieceCarrosserieRepository) {
        this.pieceCarrosserieRepository = pieceCarrosserieRepository;
    }

    public List<PieceCarrosserie> getAllPieceCarrosseries() {
        return pieceCarrosserieRepository.findAll();
    }

    public Optional<PieceCarrosserie> getPieceCarrosserie(Long id) {
        return pieceCarrosserieRepository.findById(id);
    }

    public PieceCarrosserie getTypePieceCarrosserie(TypeCarrosserie typeCarrosserie) {
        return (PieceCarrosserie) pieceCarrosserieRepository.findPieceCarrosserieByTypeCarrosserie(typeCarrosserie);
    }

    public PieceCarrosserie createPieceCarrosserie(PieceCarrosserie pieceCarrosserie) {
        return pieceCarrosserieRepository.save(pieceCarrosserie);
    }

    public void deletePieceCarrosserie(Long id) {
        pieceCarrosserieRepository.deleteById(id);
    }

    public void updatePieceCarrosserie(PieceCarrosserie pieceCarrosserie) {
        pieceCarrosserieRepository.save(pieceCarrosserie);
    }

    public PieceCarrosserie getAllByTypeCarrosserie(TypeCarrosserie typeCarrosserie) {
        return (PieceCarrosserie) pieceCarrosserieRepository.findPieceCarrosserieByTypeCarrosserie(typeCarrosserie);
    }

}

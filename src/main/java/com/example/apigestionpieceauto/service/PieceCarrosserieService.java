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
        return pieceCarrosserieRepository.findAllByOrderByIdAsc();
    }

    public Optional<PieceCarrosserie> getPieceCarrosserieById(Long id) {
        return pieceCarrosserieRepository.findById(id);
    }

    public PieceCarrosserie getTypePieceCarrosserie(TypeCarrosserie typeCarrosserie) {
        return (PieceCarrosserie) pieceCarrosserieRepository.findPieceCarrosserieByTypeCarrosserie(typeCarrosserie);
    }

    public void createPieceCarrosserie(PieceCarrosserie pieceCarrosserie) {
        pieceCarrosserieRepository.save(pieceCarrosserie);
    }

    public void deletePieceCarrosserie(Long id) {
        pieceCarrosserieRepository.deleteById(id);
    }

    public void updatePieceCarrosserie(Long id, PieceCarrosserie pieceCarrosserie) {
        Optional<PieceCarrosserie> existingPieceCarrosserieOpt = pieceCarrosserieRepository.findById(id);
        if (existingPieceCarrosserieOpt.isPresent()) {
            PieceCarrosserie existingPieceCarrosserie = existingPieceCarrosserieOpt.get();
            existingPieceCarrosserie.setNom(pieceCarrosserie.getNom());
            existingPieceCarrosserie.setReference(existingPieceCarrosserie.getReference());
            existingPieceCarrosserie.setMarque(existingPieceCarrosserie.getMarque());
            existingPieceCarrosserie.setPrix(existingPieceCarrosserie.getPrix());
            existingPieceCarrosserie.setTypeCarrosserie(pieceCarrosserie.getTypeCarrosserie());
            existingPieceCarrosserie.setCouleur(pieceCarrosserie.getCouleur());
            existingPieceCarrosserie.setFournisseur(existingPieceCarrosserie.getFournisseur());
            existingPieceCarrosserie.setVehicules(existingPieceCarrosserie.getVehicules());
            pieceCarrosserieRepository.save(existingPieceCarrosserie);
        }

//        pieceCarrosserieRepository.save(pieceCarrosserie);
    }

    public void updatePieceCarrosserie(PieceCarrosserie pieceCarrosserie) {
        /*Optional<PieceCarrosserie> existingPieceCarrosserieOpt = pieceCarrosserieRepository.findById(id);
        if (existingPieceCarrosserieOpt.isPresent()) {
            PieceCarrosserie existingPieceCarrosserie = existingPieceCarrosserieOpt.get();
            existingPieceCarrosserie.setNom(pieceCarrosserie.getNom());
            existingPieceCarrosserie.setReference(existingPieceCarrosserie.getReference());
            existingPieceCarrosserie.setMarque(existingPieceCarrosserie.getMarque());
            existingPieceCarrosserie.setPrix(existingPieceCarrosserie.getPrix());
            existingPieceCarrosserie.setTypeCarrosserie(pieceCarrosserie.getTypeCarrosserie());
            existingPieceCarrosserie.setCouleur(pieceCarrosserie.getCouleur());
            existingPieceCarrosserie.setFournisseur(existingPieceCarrosserie.getFournisseur());
            existingPieceCarrosserie.setVehicules(existingPieceCarrosserie.getVehicules());
            pieceCarrosserieRepository.save(existingPieceCarrosserie);
        }*/

        pieceCarrosserieRepository.save(pieceCarrosserie);
    }

    public PieceCarrosserie getAllByTypeCarrosserie(TypeCarrosserie typeCarrosserie) {
        return (PieceCarrosserie) pieceCarrosserieRepository.findPieceCarrosserieByTypeCarrosserie(typeCarrosserie);
    }

}

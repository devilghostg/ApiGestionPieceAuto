package com.example.apigestionpieceauto.service;

import com.example.apigestionpieceauto.Entity.PieceMoteur;
import com.example.apigestionpieceauto.repository.PieceMoteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PieceMoteurService {

    @Autowired
    private PieceMoteurRepository pieceMoteurRepository;

    @Autowired
    public PieceMoteurService(PieceMoteurRepository pieceMoteurRepository) {
        this.pieceMoteurRepository = pieceMoteurRepository;
    }

    public List<PieceMoteur> findAllPieceMoteurs() {
        return pieceMoteurRepository.findAllByOrderByIdAsc();
    }

    public Optional<PieceMoteur> findPieceMoteurById(Long id) {
        return pieceMoteurRepository.findById(id);
    }

    public PieceMoteur createPieceMoteur(PieceMoteur pieceMoteur) {
        return pieceMoteurRepository.save(pieceMoteur);
    }

    public void deletePieceMoteur(Long id) {
        pieceMoteurRepository.deleteById(id);
    }

}

package com.example.apigestionpieceauto.service;


import com.example.apigestionpieceauto.Entity.PieceAuto;
import com.example.apigestionpieceauto.repository.PieceAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PieceAutoService {

    @Autowired
    private PieceAutoRepository pieceAutoRepository;

    @Autowired
    public PieceAutoService(PieceAutoRepository pieceAutoRepository) {
        this.pieceAutoRepository = pieceAutoRepository;
    }

    public List<PieceAuto> getAllPieceAuto() {
        return (List<PieceAuto>) pieceAutoRepository.findAll();
    }

    public Optional<PieceAuto> getPieceAutoById(Long id) {
        return pieceAutoRepository.findById(id);
    }

    public PieceAuto createPieceAuto(PieceAuto pieceAuto) {
        return pieceAutoRepository.save(pieceAuto);
    }

    public void deletePieceAutoById(Long id) {
        pieceAutoRepository.deleteById(id);
    }

}

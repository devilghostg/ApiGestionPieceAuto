package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.Entity.PieceMoteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceMoteurRepository extends CrudRepository<PieceMoteur, Long> {
    List<PieceMoteur> findAllByOrderByIdAsc();
}
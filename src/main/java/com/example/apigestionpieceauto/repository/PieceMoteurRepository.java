package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.PieceMoteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceMoteurRepository extends CrudRepository<PieceMoteur, Long> {
}
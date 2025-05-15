package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.PieceMoteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "piecemoteur")
public interface PieceMoteurRepository extends JpaRepository<PieceMoteur, Long> {
}
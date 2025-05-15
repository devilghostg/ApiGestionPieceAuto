package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.PieceCarrosserie;
import com.example.apigestionpieceauto.model.TypeCarrosserie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "piececarrosserie")
public interface PieceCarrosserieRepository extends JpaRepository<PieceCarrosserie, Long> {
    List<PieceCarrosserie> findPieceCarrosserieByTypeCarrosserie(TypeCarrosserie typeCarrosserie);
}
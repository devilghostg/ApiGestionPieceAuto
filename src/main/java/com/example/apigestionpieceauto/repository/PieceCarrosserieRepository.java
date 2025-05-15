package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.PieceCarrosserie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "piececarrosserie")
public interface PieceCarrosserieRepository extends JpaRepository<PieceCarrosserie, Long> {
}
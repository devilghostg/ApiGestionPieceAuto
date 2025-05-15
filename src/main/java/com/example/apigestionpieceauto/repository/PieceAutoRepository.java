package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.PieceAuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pieceauto")
public interface PieceAutoRepository extends JpaRepository<PieceAuto, Long> {
}
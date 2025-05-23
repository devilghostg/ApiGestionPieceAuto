package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.Entity.PieceCarrosserie;
import com.example.apigestionpieceauto.Entity.TypeCarrosserie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceCarrosserieRepository extends JpaRepository<PieceCarrosserie, Long> {
    List<PieceCarrosserie> findPieceCarrosserieByTypeCarrosserie(TypeCarrosserie typeCarrosserie);

    List<PieceCarrosserie> findAllByOrderByIdAsc();
}
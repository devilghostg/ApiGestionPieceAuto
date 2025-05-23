package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.Entity.PieceAuto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PieceAutoRepository extends CrudRepository<PieceAuto, Long> {
    List<PieceAuto> findAllByOrderByIdAsc();
}
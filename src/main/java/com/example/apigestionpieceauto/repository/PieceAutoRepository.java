package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.PieceAuto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceAutoRepository extends CrudRepository<PieceAuto, Long> {
}
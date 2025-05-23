package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.Entity.Vehicule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {
    List<Vehicule> findAllByOrderByIdAsc();
}
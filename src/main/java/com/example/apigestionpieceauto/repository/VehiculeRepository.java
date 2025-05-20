package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.Vehicule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {
}
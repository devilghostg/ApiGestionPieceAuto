package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.Vehicule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "vehicule")
public interface VehiculeRepository extends CrudRepository<Vehicule, Long> {
}
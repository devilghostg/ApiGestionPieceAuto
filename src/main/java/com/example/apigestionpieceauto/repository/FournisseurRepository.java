package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.Fournisseur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "fournisseur")
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
}
package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.model.Fournisseur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
}
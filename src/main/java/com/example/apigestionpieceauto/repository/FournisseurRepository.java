package com.example.apigestionpieceauto.repository;

import com.example.apigestionpieceauto.Entity.Fournisseur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FournisseurRepository extends CrudRepository<Fournisseur, Long> {
    List<Fournisseur> findAllByOrderByIdAsc();
}
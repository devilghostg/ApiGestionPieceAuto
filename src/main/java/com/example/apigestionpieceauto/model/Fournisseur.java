package com.example.apigestionpieceauto.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "fournisseur")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String nom;
    private String adresse;
    private String telephone;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PieceAuto> pieceAutos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
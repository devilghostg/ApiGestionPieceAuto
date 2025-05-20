package com.example.apigestionpieceauto.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<PieceAuto> pieceAutos;

    public Fournisseur() {
    }

    public Fournisseur(Long id, String nom, String adresse, String telephone, Set<PieceAuto> pieceAutos) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.pieceAutos = pieceAutos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<PieceAuto> getPieceAutos() {
        return pieceAutos;
    }

    public void setPieceAutos(Set<PieceAuto> pieceAutos) {
        this.pieceAutos = pieceAutos;
    }
}
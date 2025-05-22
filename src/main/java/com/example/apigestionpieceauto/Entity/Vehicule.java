package com.example.apigestionpieceauto.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vehicule")
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String marque;
    private String modele;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date annee;
    private String immatriculation;

    @ManyToMany
    private Set<PieceAuto> pieceAutos;

    public Vehicule() {}

    public Vehicule(String marque, String modele, Date annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    public Vehicule(Long id, String marque, String modele, Date annee, String immatriculation, Set<PieceAuto> pieceAutos) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.immatriculation = immatriculation;
        pieceAutos = pieceAutos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Date getAnnee() {
        return annee;
    }

    public void setAnnee(Date annee) {
        this.annee = annee;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public Set<PieceAuto> getPieceAutos() {
        return pieceAutos;
    }

    public void setPieceAutos(Set<PieceAuto> pieceAutos) {
        pieceAutos = pieceAutos;
    }
}
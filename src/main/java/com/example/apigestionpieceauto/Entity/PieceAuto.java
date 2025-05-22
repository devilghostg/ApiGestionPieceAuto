package com.example.apigestionpieceauto.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class PieceAuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String reference;
    private String nom;
    private String marque;
    private Integer prix;

    @ManyToOne
    @JoinColumn(name = "fournisseur_id")
    @JsonBackReference
    private Fournisseur fournisseur;

    @ManyToMany(mappedBy = "pieceAutos")
    private Set<Vehicule> vehicules;

    public Long getId() {
        return id;
    }

    private Integer stock;

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public PieceAuto(Long id, String reference, String nom, String marque, Integer prix) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
    }

    public PieceAuto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String references) {
        this.reference = references;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Set<Vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(Set<Vehicule> vehicules) {
        this.vehicules = vehicules;
    }

}
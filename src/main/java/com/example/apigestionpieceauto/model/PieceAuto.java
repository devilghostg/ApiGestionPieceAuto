package com.example.apigestionpieceauto.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "piece_auto")
public class PieceAuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String references;
    private String nom;
    private String marque;
    private Integer prix;

    @ManyToOne
    private Fournisseur fournisseur;

    @ManyToMany(mappedBy = "pieceAutos")
    private Set<Vehicule> vehicules;



    public Long getId() {
        return id;
    }

    public PieceAuto(Long id, String references, String nom, String marque, Integer prix) {
        this.id = id;
        this.references = references;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
    }

    public PieceAuto() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
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
}
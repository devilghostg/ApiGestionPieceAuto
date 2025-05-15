package com.example.apigestionpieceauto.model;

import jakarta.persistence.*;


@Entity
public class PieceCarrosserie extends PieceAuto {

    private Long id;
    private String couleur;
    @Enumerated(EnumType.STRING)
    private TypeCarrosserie typeCarrosserie;

    public PieceCarrosserie(Long id, String references, String nom, String marque, Integer prix, Long id1, String couleur, TypeCarrosserie typeCarrosserie) {
        super(id, references, nom, marque, prix);
        this.id = id1;
        this.couleur = couleur;
        this.typeCarrosserie = typeCarrosserie;
    }

    public PieceCarrosserie(Long id, String couleur, TypeCarrosserie typeCarrosserie) {
        this.id = id;
        this.couleur = couleur;
        this.typeCarrosserie = typeCarrosserie;
    }

    public PieceCarrosserie() {

    }



    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public TypeCarrosserie getTypeCarrosserie() {
        return typeCarrosserie;
    }

    public void setTypeCarrosserie(TypeCarrosserie typeCarrosserie) {
        this.typeCarrosserie = typeCarrosserie;
    }
}
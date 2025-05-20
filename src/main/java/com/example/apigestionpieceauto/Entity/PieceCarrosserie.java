package com.example.apigestionpieceauto.Entity;

import jakarta.persistence.*;


@Entity
public class PieceCarrosserie extends PieceAuto {

    private String couleur;
    @Enumerated(EnumType.STRING)
    private TypeCarrosserie typeCarrosserie;

    public PieceCarrosserie(Long id, String references, String nom, String marque, Integer prix, String couleur, TypeCarrosserie typeCarrosserie) {
        super(id, references, nom, marque, prix);
        this.couleur = couleur;
        this.typeCarrosserie = typeCarrosserie;
    }

    public PieceCarrosserie( String couleur, TypeCarrosserie typeCarrosserie) {
        this.couleur = couleur;
        this.typeCarrosserie = typeCarrosserie;
    }

    public PieceCarrosserie() {

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
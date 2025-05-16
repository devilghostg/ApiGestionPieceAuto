package com.example.apigestionpieceauto.dto;

import com.example.apigestionpieceauto.model.TypeMoteur;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.example.apigestionpieceauto.model.PieceMoteur}
 */
public class PieceMoteurDto implements Serializable {
    private final Long id;
    private final String reference;
    private final String nom;
    private final String marque;
    private final Integer prix;
    private final Integer puissance;
    private final TypeMoteur typeMoteur;

    public PieceMoteurDto(Long id, String reference, String nom, String marque, Integer prix, Integer puissance, TypeMoteur typeMoteur) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.puissance = puissance;
        this.typeMoteur = typeMoteur;
    }

    public Long getId() {
        return id;
    }

    public String getReference() {
        return reference;
    }

    public String getNom() {
        return nom;
    }

    public String getMarque() {
        return marque;
    }

    public Integer getPrix() {
        return prix;
    }

    public Integer getPuissance() {
        return puissance;
    }

    public TypeMoteur getTypeMoteur() {
        return typeMoteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceMoteurDto entity = (PieceMoteurDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.reference, entity.reference) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.marque, entity.marque) &&
                Objects.equals(this.prix, entity.prix) &&
                Objects.equals(this.puissance, entity.puissance) &&
                Objects.equals(this.typeMoteur, entity.typeMoteur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, nom, marque, prix, puissance, typeMoteur);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "reference = " + reference + ", " +
                "nom = " + nom + ", " +
                "marque = " + marque + ", " +
                "prix = " + prix + ", " +
                "puissance = " + puissance + ", " +
                "typeMoteur = " + typeMoteur + ")";
    }
}
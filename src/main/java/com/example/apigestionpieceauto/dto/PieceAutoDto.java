package com.example.apigestionpieceauto.dto;

import com.example.apigestionpieceauto.model.Vehicule;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.example.apigestionpieceauto.model.PieceAuto}
 */
public class PieceAutoDto implements Serializable {
    private final Long id;
    private final String reference;
    private final String nom;
    private final String marque;
    private final Integer prix;
    private final Set<Vehicule> vehicules;

    public PieceAutoDto(Long id, String reference, String nom, String marque, Integer prix, Set<Vehicule> vehicules) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
        this.marque = marque;
        this.prix = prix;
        this.vehicules = vehicules;
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

    public Set<Vehicule> getVehicules() {
        return vehicules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PieceAutoDto entity = (PieceAutoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.reference, entity.reference) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.marque, entity.marque) &&
                Objects.equals(this.prix, entity.prix) &&
                Objects.equals(this.vehicules, entity.vehicules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, nom, marque, prix, vehicules);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "reference = " + reference + ", " +
                "nom = " + nom + ", " +
                "marque = " + marque + ", " +
                "prix = " + prix + ", " +
                "vehicules = " + vehicules + ")";
    }
}
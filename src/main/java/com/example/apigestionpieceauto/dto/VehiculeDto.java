package com.example.apigestionpieceauto.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * DTO for {@link com.example.apigestionpieceauto.model.Vehicule}
 */
public class VehiculeDto implements Serializable {
    private final Long id;
    private final String marque;
    private final String modele;
    private final Date annee;
    private final String immatriculation;
    private final Set<PieceAutoDto> pieceAutos;

    public VehiculeDto(Long id, String marque, String modele, Date annee, String immatriculation, Set<PieceAutoDto> pieceAutos) {
        this.id = id;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.immatriculation = immatriculation;
        this.pieceAutos = pieceAutos;
    }

    public Long getId() {
        return id;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public Date getAnnee() {
        return annee;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public Set<PieceAutoDto> getPieceAutos() {
        return pieceAutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehiculeDto entity = (VehiculeDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.marque, entity.marque) &&
                Objects.equals(this.modele, entity.modele) &&
                Objects.equals(this.annee, entity.annee) &&
                Objects.equals(this.immatriculation, entity.immatriculation) &&
                Objects.equals(this.pieceAutos, entity.pieceAutos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marque, modele, annee, immatriculation, pieceAutos);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "marque = " + marque + ", " +
                "modele = " + modele + ", " +
                "annee = " + annee + ", " +
                "immatriculation = " + immatriculation + ", " +
                "pieceAutos = " + pieceAutos + ")";
    }
}
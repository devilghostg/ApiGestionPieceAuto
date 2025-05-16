package com.example.apigestionpieceauto.dto;

import com.example.apigestionpieceauto.model.Fournisseur;
import com.example.apigestionpieceauto.model.PieceAuto;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * DTO for {@link com.example.apigestionpieceauto.model.Fournisseur}
 */
public class FournisseurDto implements Serializable {
    private final Long id;
    private final String nom;
    private final String adresse;
    private final String telephone;
    private final Set<PieceAutoDto> pieceAutos;

    public FournisseurDto(Long id, String nom, String adresse, String telephone, Set<PieceAutoDto> pieceAutos) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.pieceAutos = pieceAutos;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public Set<PieceAutoDto> getPieceAutos() {
        return pieceAutos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FournisseurDto entity = (FournisseurDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nom, entity.nom) &&
                Objects.equals(this.adresse, entity.adresse) &&
                Objects.equals(this.telephone, entity.telephone) &&
                Objects.equals(this.pieceAutos, entity.pieceAutos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, adresse, telephone, pieceAutos);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nom = " + nom + ", " +
                "adresse = " + adresse + ", " +
                "telephone = " + telephone + ", " +
                "pieceAutos = " + pieceAutos + ")";
    }

    public static Fournisseur toEntity(FournisseurDto fournisseurDto) {
        if (fournisseurDto == null) return null;

        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(fournisseurDto.getId());
        fournisseur.setNom(fournisseurDto.getNom());
        fournisseur.setAdresse(fournisseurDto.getAdresse());
        fournisseur.setTelephone(fournisseurDto.getTelephone());

        if (fournisseurDto.getPieceAutos() != null) {
            Set<PieceAuto> pieces = fournisseurDto.getPieceAutos()
                    .stream()
                    .map(pieceDto -> {
                        PieceAuto piece = toPieceAutoEntity(pieceDto);
                        piece.setFournisseur(fournisseur); // Important pour la relation bidirectionnelle
                        return piece;
                    })
                    .collect(Collectors.toSet());
            fournisseur.setPieceAutos(pieces);
        }

        return fournisseur;
    }

    public static PieceAutoDto toPieceAutoDTO(PieceAuto piece) {
        if (piece == null) return null;

        return new PieceAutoDto(
                piece.getId(),
                piece.getReference(),
                piece.getNom(),
                piece.getMarque(),
                piece.getPrix(),
                piece.getVehicules()
        );
    }

    public static PieceAuto toPieceAutoEntity(PieceAutoDto dto) {
        if (dto == null) return null;

        PieceAuto piece = new PieceAuto();
        piece.setId(dto.getId());
        piece.setNom(dto.getNom());
        piece.setPrix(dto.getPrix());

        return piece;
    }
}
package com.example.apigestionpieceauto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class PieceMoteur extends PieceAuto {

    private Long id;
    private Integer puissance;
    @Enumerated(EnumType.STRING)
    private TypeMoteur typeMoteur;

    public PieceMoteur() {}

    public PieceMoteur(Long id, String references, String nom, String marque, Integer prix, Long id1, Integer puissance, TypeMoteur typeMoteur) {
        super(id, references, nom, marque, prix);
        this.id = id1;
        this.puissance = puissance;
        this.typeMoteur = typeMoteur;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPuissance() {
        return puissance;
    }

    public void setPuissance(Integer puissance) {
        this.puissance = puissance;
    }

    public TypeMoteur getTypeMoteur() {
        return typeMoteur;
    }

    public void setTypeMoteur(TypeMoteur typeMoteur) {
        this.typeMoteur = typeMoteur;
    }
}
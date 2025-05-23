package com.example.apigestionpieceauto.Entity;

public enum TypeCarrosserie {
    ACIER("Acier"),
    ALUMINIUM("Aluminium"),
    PLASTIQUE("Platique"),
    CABORNE("Caborne"),
    FIBRE("Fibre");

    public final String label;

    TypeCarrosserie(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

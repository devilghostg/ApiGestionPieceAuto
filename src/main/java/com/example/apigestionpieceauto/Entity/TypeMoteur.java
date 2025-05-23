package com.example.apigestionpieceauto.Entity;

public enum TypeMoteur {
    MANUEL("Manuel"),
    AUTOMATIQUE("Automatique"),
    ELECTRIQUE("Electrique"),
    HYBRID("Hybrid"),
    GAZOLINE("Gazoline");

    public final String label;

    TypeMoteur(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}

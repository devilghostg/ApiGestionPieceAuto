package com.example.apigestionpieceauto.model;

import jakarta.persistence.*;

@Entity
@Table(name = "piece_auto")
public class PieceAuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
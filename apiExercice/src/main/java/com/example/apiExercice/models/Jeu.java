package com.example.apiExercice.models;


import jakarta.persistence.*;
import org.springframework.context.annotation.EnableMBeanExport;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

@Table(name="jeu")
@Entity
public class Jeu {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "entreprise_id") //dans jeu, quel sera la colonne en db qui comportera notre foreign key : id
    private Entreprise entreprise;

    public Jeu() {

    }


    public Jeu(BigDecimal price) {
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}


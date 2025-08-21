package com.example.apiExercice.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonBackReference //indiquer que la propriété associé fait partie d'un lien entre deux champs

    private Entreprise entreprise;


    @Transient //spécifie que la propriété n'est pas persistante
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private UUID entrepriseId;

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

    public UUID getEntrepriseId() {
        return entrepriseId;
    }

    public void setEntrepriseId(UUID entrepriseId) {
        this.entrepriseId = entrepriseId;
    }
}


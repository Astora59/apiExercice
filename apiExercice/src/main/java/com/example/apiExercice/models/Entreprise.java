package com.example.apiExercice.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Table(name="entreprise")
@Entity
public class Entreprise {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String adresse;

    @OneToMany(mappedBy = "entreprise", cascade = CascadeType.ALL)
    @JsonManagedReference //tu as une liste de jeux que tu peux afficher, mais attention il y a un JsonBackReference donc n'affiche pas les entreprises dans les jeux
    private Set<Jeu> jeux = new HashSet<Jeu>();


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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Set<Jeu> getJeux() {
        return jeux;
    }

    public void setJeux(Set<Jeu> jeux) {
        this.jeux = jeux;
    }
}

package com.example.apiExercice.services;



import com.example.apiExercice.models.Jeu;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

//va servir à lister les fonctions disponibles
public interface JeuService {



    public Jeu findById(UUID id);


    Set<Jeu> findAllOfEntreprise(UUID idEntreprise);

    UUID create(UUID idEntreprise, Jeu jeu);

    void update(UUID id, Jeu jeu);

    void deleteById(UUID id);
}

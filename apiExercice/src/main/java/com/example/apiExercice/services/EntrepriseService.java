package com.example.apiExercice.services;

import com.example.apiExercice.models.Entreprise;

import java.util.List;
import java.util.Map;
import java.util.UUID;

//va servir à lister les fonctions disponibles
public interface EntrepriseService {


    List<Entreprise> findAll(); //on ne met pas le contenu de la fonction, c'est pas là qu'on la met

    Entreprise findById(UUID id);

    UUID create(Entreprise entreprise);


    void update(UUID id, Entreprise entreprise);

    void partialUpdate(UUID id, Map<String, Object> updates);

    void deleteById(UUID id);
}

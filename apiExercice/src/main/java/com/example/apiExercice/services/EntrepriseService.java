package com.example.apiExercice.services;

import com.example.apiExercice.models.Entreprise;

import java.util.List;
//va servir à lister les fonctions disponibles
public interface EntrepriseService {

    public List<Entreprise> findAll(); //on ne met pas le contenu de la fonction, c'est pas là qu'on la met

}

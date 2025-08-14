package com.example.apiExercice.controllers;

import com.example.apiExercice.models.Entreprise;
import com.example.apiExercice.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController //@RestController : permet d’indiquer à Spring qu’on est sur un controller REST (et qui va avoir des verbes HTTP)
@RequestMapping("/entreprises") // pour accéder aux entreprises, on va avoir un requestMapping = endpoint /entreprises
public class EntrepriseController {

    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping //on va exposer la méthode findAll : on va lui indiquer le verbe http lié à findAll : il s’agit de GET. C’est une annotation pour mapper un HTTP get au niveau de la fonction
    public List<Entreprise> findAll() {

        return entrepriseService.findAll(); //traduction : je vais dans l'impl et je fais appel à ma méthode findAll
    }
    @GetMapping("/{id}")
    public Entreprise findById(@PathVariable UUID id)  {

        Entreprise entreprise = entrepriseService.findById(id);
        return entreprise;

    }
}

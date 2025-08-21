package com.example.apiExercice.controllers;



import com.example.apiExercice.models.Jeu;

import com.example.apiExercice.services.EntrepriseService;
import com.example.apiExercice.services.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
import java.util.Set;
import java.util.UUID;

@RestController //@RestController : permet d’indiquer à Spring qu’on est sur un controller REST (et qui va avoir des verbes HTTP)
public class JeuController {

    @Autowired
    private JeuService jeuService;

    @Autowired
    private EntrepriseService entrepriseService;

    @GetMapping("/jeux/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    //on va exposer la méthode findAll : on va lui indiquer le verbe http lié à findAll : il s’agit de GET. C’est une annotation pour mapper un HTTP get au niveau de la fonction
    public Jeu findById(@PathVariable UUID id) {

        return jeuService.findById(id); //traduction : je vais dans l'impl et je fais appel à ma méthode findAll
    }

    @GetMapping("/entreprises/{idEntreprise}/jeux")
    @ResponseStatus(code = HttpStatus.OK)
    public Set<Jeu> findAllOfEntreprise(@PathVariable UUID idEntreprise) {

        //je m'assure que l'id existe bien
        entrepriseService.findById(idEntreprise);

        return jeuService.findAllOfEntreprise(idEntreprise);

    }

    @PostMapping("/entreprises/{idEntreprise}/jeux")
    @ResponseStatus(code = HttpStatus.CREATED)
    public UUID create(@PathVariable UUID idEntreprise, @RequestBody Jeu jeu) {

        //je m'assure que l'id existe bien
        entrepriseService.findById(idEntreprise);

        return jeuService.create(idEntreprise, jeu);

    }

    @PutMapping("/jeux/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@PathVariable UUID id, @RequestBody Jeu jeu) {

        //je m'assure que le jeu existe
        jeuService.findById(id);

        jeuService.update(id, jeu);

    }

    @DeleteMapping("/jeux/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {

        //je m'assure que le jeu existe
        jeuService.findById(id);


        jeuService.deleteById(id);

    }

    @PatchMapping("/jeux/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public void partialUpdate(@PathVariable UUID id, @RequestBody Map<String, Object> updates) {

        jeuService.findById(id);

        jeuService.partialUpdate(id, updates);

    }


}

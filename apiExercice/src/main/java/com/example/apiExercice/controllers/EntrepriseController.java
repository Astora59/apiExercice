package com.example.apiExercice.controllers;


import com.example.apiExercice.models.Entreprise;
import com.example.apiExercice.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

        return entrepriseService.findById(id);

    }

    @PostMapping //pour dire qu'il y aura un POST ici
    @ResponseStatus(code = HttpStatus.CREATED) //pour qu'on ait un code 201 et pas 200, on fait ça
    public UUID Create(@RequestBody Entreprise entreprise) {

        return entrepriseService.create(entreprise);

    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK) //pour qu'on ait un code 201 et pas 200, on fait ça
    public void update(@PathVariable UUID id, @RequestBody Entreprise entreprise) {

        //controle l'existencd de mon entité
        entrepriseService.findById(id);

        entrepriseService.update(id, entreprise);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK) //pour qu'on ait un code 201 et pas 200, on fait ça
    public void partialUpdate(@PathVariable UUID id, @RequestBody Map<String, Object> updates) {


        entrepriseService.findById(id);

        entrepriseService.partialUpdate(id, updates);


    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {

        entrepriseService.findById(id);

        entrepriseService.deleteById(id);

    }
}

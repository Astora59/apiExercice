package com.example.apiExercice.controllers;

import com.example.apiExercice.models.Entreprise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController //@RestController : permet d’indiquer à Spring qu’on est sur un controller REST (et qui va avoir des verbes HTTP)
@RequestMapping("/entreprises") // pour accéder aux entreprises, on va avoir un requestMapping = endpoint /entreprises
public class EntrepriseController {
    @GetMapping //on va exposer la méthode findAll : on va lui indiquer le verbe http lié à findAll : il s’agit de GET. C’est une annotation pour mapper un HTTP get au niveau de la fonction
    public List<Entreprise> findAll() {

        List<Entreprise> liste = new ArrayList<Entreprise>();

        Entreprise e1 = new Entreprise();
        e1.setId(UUID.randomUUID()); //on attribue un UUID random
        e1.setName("Entreprise Alpha");
        e1.setAdresse("15 rue Victor Hugo, 59150 Wattrelos");
        liste.add(e1);

        Entreprise e2 = new Entreprise();
        e2.setId(UUID.randomUUID()); //on attribue un UUID random
        e2.setName("Entreprise  Beta");
        e2.setAdresse("15 rue Guy de Maupassant, 59000 Lille");
        liste.add(e2);
        return liste;
    }
}

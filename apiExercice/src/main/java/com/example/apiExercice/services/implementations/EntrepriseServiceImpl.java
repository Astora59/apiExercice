package com.example.apiExercice.services.implementations;

import com.example.apiExercice.models.Entreprise;
import com.example.apiExercice.services.EntrepriseService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service //indique que cette classe est un service qu'on peut injecter dans un autre composant
public class EntrepriseServiceImpl implements EntrepriseService {
    @Override //indique que la classe va réécrire findAll
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

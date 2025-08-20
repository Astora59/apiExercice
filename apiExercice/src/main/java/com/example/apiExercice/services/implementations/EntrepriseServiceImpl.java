package com.example.apiExercice.services.implementations;

import com.example.apiExercice.exceptions.ResourceNotFoundException;
import com.example.apiExercice.models.Entreprise;
import com.example.apiExercice.repositories.EntrepriseRepository;
import com.example.apiExercice.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service //indique que cette classe est un service qu'on peut injecter dans un autre composant
public class EntrepriseServiceImpl implements EntrepriseService {

    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Override //indique que la classe va réécrire findAll
    public List<Entreprise> findAll() {
        List<Entreprise> list = new ArrayList<Entreprise>();

        entrepriseRepository.findAll().forEach(list::add); //pour chaque entreprise trouver dans le findAll, je vais l'ajouter à la liste

        return list;

    }

    @Override
    public Entreprise findById(UUID id) {

        return entrepriseRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public UUID create(Entreprise entreprise) {

        return entrepriseRepository.save(entreprise).getId();

    }

    @Override
    public void update(UUID id, Entreprise entreprise) {

        entreprise.setId(id);
        entrepriseRepository.save(entreprise);

    }

    @Override
    public void partialUpdate(UUID id, Map<String, Object> updates) {

        Entreprise entrepriseToUpdate = entrepriseRepository.findById(id).get();

        //on boucle sur tous les champs
        for(String key : updates.keySet()) {

            switch(key) {
                case "name" : {
                    entrepriseToUpdate.setName((String) updates.get(key));
                    break;
                }

                case "adresse" : {
                    entrepriseToUpdate.setAdresse((String) updates.get(key));
                    break;
                }
            }


        }

        entrepriseRepository.save(entrepriseToUpdate);
    }

    @Override
    public void deleteById(UUID id) {

        entrepriseRepository.deleteById(id);

    }


}

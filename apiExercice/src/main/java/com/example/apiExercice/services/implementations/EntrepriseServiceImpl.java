package com.example.apiExercice.services.implementations;

import com.example.apiExercice.models.Entreprise;
import com.example.apiExercice.repositories.EntrepriseRepository;
import com.example.apiExercice.services.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

        //si je trouve l'entreprise
        if(entrepriseRepository.findById(id).isPresent()) {

            return entrepriseRepository.findById(id).get();

        }
        //si je ne trouve pas l'entreprise
        return null;
    }

    @Override
    public UUID create(Entreprise entreprise) {

        return entrepriseRepository.save(entreprise).getId();

    }
}

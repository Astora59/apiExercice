package com.example.apiExercice.services.implementations;

import com.example.apiExercice.exceptions.ResourceNotFoundException;
import com.example.apiExercice.models.Entreprise;
import com.example.apiExercice.models.Jeu;
import com.example.apiExercice.repositories.EntrepriseRepository;
import com.example.apiExercice.repositories.JeuRepository;
import com.example.apiExercice.services.EntrepriseService;
import com.example.apiExercice.services.JeuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service //indique que cette classe est un service qu'on peut injecter dans un autre composant
public class JeuServiceImpl implements JeuService {

    @Autowired
    private JeuRepository jeuRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;


    @Override
    public Jeu findById(UUID id) {

        return jeuRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Set<Jeu> findAllOfEntreprise(UUID idEntreprise) {

        return entrepriseRepository.findById(idEntreprise).get().getJeux();

    }


}

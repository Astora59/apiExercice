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

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

@Service //indique que cette classe est un service qu'on peut injecter dans un autre composant
public class JeuServiceImpl implements JeuService {

    @Autowired
    private JeuRepository jeuRepository;

    @Autowired
    private EntrepriseRepository entrepriseRepository;


    @Autowired
    private EntrepriseService entrepriseService;



    @Override
    public Jeu findById(UUID id) {

        return jeuRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Set<Jeu> findAllOfEntreprise(UUID idEntreprise) {

        return entrepriseRepository.findById(idEntreprise).get().getJeux();

    }

    @Override
    public UUID create(UUID idEntreprise, Jeu jeu) {


        Entreprise entreprise = entrepriseRepository.findById(idEntreprise).get();
        jeu.setEntreprise(entreprise);

        jeuRepository.save(jeu);
        return jeu.getId();


    }

    @Override
    public void update(UUID id, Jeu jeu) {

        //je relie le jeu avec son id
        jeu.setId(id);
        Entreprise entreprise = entrepriseService.findById(jeu.getEntrepriseId());
        //j'associe le jeu avec son objet entreprise, pas son id
        jeu.setEntreprise(entreprise);
        //on va faire un update, et pas un insert
        jeuRepository.save(jeu);

    }

    @Override
    public void deleteById(UUID id) {

        jeuRepository.deleteById(id);

    }

    @Override
    public void partialUpdate(UUID id, Map<String, Object> updates) {

        Jeu jeuToUpdate = jeuRepository.findById(id).get();

        //on boucle sur tous les champs
        for(String key : updates.keySet()) {

            switch(key) {
                case "name" : {
                    jeuToUpdate.setName((String) updates.get(key));
                    break;
                }

                case "price" : {
                    jeuToUpdate.setPrice((BigDecimal) updates.get(key));
                    break;
                }
            }


        }



    }


}

package com.example.apiExercice.repositories;

import com.example.apiExercice.models.Entreprise;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EntrepriseRepository extends CrudRepository<Entreprise, UUID> {
}

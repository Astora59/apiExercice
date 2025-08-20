package com.example.apiExercice.repositories;

import com.example.apiExercice.models.Jeu;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface JeuRepository extends CrudRepository<Jeu, UUID> {
}

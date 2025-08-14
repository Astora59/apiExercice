package com.example.apiExercice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;


}
//quand l'exception est levé, j'ai un code d'erreur associé qui est correct. Car chaque code d'erreur a sa signification.
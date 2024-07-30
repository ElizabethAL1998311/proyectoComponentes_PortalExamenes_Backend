package com.example.proyectocomponentesbackend.Exepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException{
    private static  final long serialVersionID = 1L;

    public ResourceNotFoundExeption(String mensaje){
        super(mensaje);
    }
}

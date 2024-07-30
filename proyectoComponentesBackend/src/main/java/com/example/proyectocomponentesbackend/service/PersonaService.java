package com.example.proyectocomponentesbackend.service;

import com.example.proyectocomponentesbackend.model.Persona;
import com.example.proyectocomponentesbackend.model.PersonaRol;
import java.util.Set;
public interface PersonaService {

    public Persona guardarPersona(Persona usuario, Set<PersonaRol> personaRols) throws Exception;

    public Persona obtenerPersona(String username);

    public void eliminarPersona(Long personaId);
}

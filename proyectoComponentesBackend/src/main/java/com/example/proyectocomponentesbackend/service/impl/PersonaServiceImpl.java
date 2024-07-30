package com.example.proyectocomponentesbackend.service.impl;

import com.example.proyectocomponentesbackend.excepciones.UsuarioFoundException;
import com.example.proyectocomponentesbackend.model.Persona;
import com.example.proyectocomponentesbackend.model.PersonaRol;
import com.example.proyectocomponentesbackend.repository.PersonaRepository;
import com.example.proyectocomponentesbackend.repository.RolRepository;
import com.example.proyectocomponentesbackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Persona guardarPersona(Persona persona, Set<PersonaRol> personaRols) throws Exception {
        Persona personaLocal = personaRepository.findByUsername(persona.getUsername());
        if(personaLocal != null){
            System.out.println("El usuario ya existe");
            throw new UsuarioFoundException("El usuario ya esta presente");
        }
        else{
            for(PersonaRol personaRol:personaRols){
                rolRepository.save(personaRol.getRol());
            }
            persona.getUsuarioRol().addAll(personaRols);
            personaLocal = personaRepository.save(persona);
        }
        return personaLocal;
    }

    @Override
    public Persona obtenerPersona(String username) {
        return personaRepository.findByUsername(username);
    }

    @Override
    public void eliminarPersona(Long personaId) {
        personaRepository.deleteById(personaId);
    }
}
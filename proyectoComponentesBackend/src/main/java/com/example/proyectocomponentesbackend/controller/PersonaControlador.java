package com.example.proyectocomponentesbackend.controller;

import com.example.proyectocomponentesbackend.Exepciones.ResourceNotFoundExeption;
import com.example.proyectocomponentesbackend.model.Persona;
import com.example.proyectocomponentesbackend.model.PersonaRol;
import com.example.proyectocomponentesbackend.model.Rol;
import com.example.proyectocomponentesbackend.repository.PersonaRepository;
import com.example.proyectocomponentesbackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/personas")
@CrossOrigin("*")
public class PersonaControlador {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/")
    public Persona guardarUsuario(@RequestBody Persona persona) throws Exception{
        persona.setPerfil("default.png");

        persona.setPassword(this.bCryptPasswordEncoder.encode(persona.getPassword()));
        Set<PersonaRol> personaRoles = new HashSet<>();

        Rol rol = new Rol();
        rol.setId(2L);
        rol.setRolNombre("Normal");


        PersonaRol personaRol = new PersonaRol();
        personaRol.setPersona(persona);
        personaRol.setRol(rol);



        personaRoles.add(personaRol);
        return personaService.guardarPersona(persona,personaRoles);
    }


    @GetMapping("/{username}")
    public Persona obtenerPersona(@PathVariable("username") String username){
        return personaService.obtenerPersona(username);
    }

    @DeleteMapping("/{personaId}")
    public void eliminarUsuario(@PathVariable("personaId") Long personaId){
        personaService.eliminarPersona(personaId);
    }

}

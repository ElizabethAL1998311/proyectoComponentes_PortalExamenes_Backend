package com.example.proyectocomponentesbackend.service.impl;

import com.example.proyectocomponentesbackend.model.Persona;
import com.example.proyectocomponentesbackend.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonaDetailsServerImpl implements UserDetailsService {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Persona persona = this.personaRepository.findByUsername(username);
        if(persona == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return persona;
    }
}

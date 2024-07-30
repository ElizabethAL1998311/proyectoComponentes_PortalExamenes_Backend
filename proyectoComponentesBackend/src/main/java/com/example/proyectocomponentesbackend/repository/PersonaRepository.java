package com.example.proyectocomponentesbackend.repository;

import com.example.proyectocomponentesbackend.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {

    public Persona findByUsername(String username);


}
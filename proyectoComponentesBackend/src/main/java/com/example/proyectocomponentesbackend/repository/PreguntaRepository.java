package com.example.proyectocomponentesbackend.repository;

import com.example.proyectocomponentesbackend.model.Examen;
import com.example.proyectocomponentesbackend.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface PreguntaRepository extends JpaRepository<Pregunta,Long> {

    Set<Pregunta> findByExamen(Examen examen);
}

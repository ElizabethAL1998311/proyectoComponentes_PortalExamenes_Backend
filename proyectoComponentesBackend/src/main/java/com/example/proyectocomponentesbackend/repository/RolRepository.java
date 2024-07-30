package com.example.proyectocomponentesbackend.repository;

import com.example.proyectocomponentesbackend.model.Persona;
import com.example.proyectocomponentesbackend.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {

}

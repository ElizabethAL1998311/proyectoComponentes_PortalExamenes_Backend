package com.example.proyectocomponentesbackend.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "tbl_rol_apadillale_earaias")
public class Rol {
    @Id
    private long id;
    private String rolNombre;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "rol")
    private Set<PersonaRol> personaRoles = new HashSet<>();


    public Rol() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Set<PersonaRol> getPersonaRoles() {
        return personaRoles;
    }

    public void setPersonaRoles(Set<PersonaRol> personaRoles) {
        this.personaRoles = personaRoles;
    }
}

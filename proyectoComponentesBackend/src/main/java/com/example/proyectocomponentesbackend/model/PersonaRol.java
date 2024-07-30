package com.example.proyectocomponentesbackend.model;



import javax.persistence.*;

@Entity
public class PersonaRol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long personaRolId;
    @ManyToOne(fetch = FetchType.EAGER)
    private Persona persona;

    @ManyToOne(fetch = FetchType.EAGER)
    private Rol rol;

    public PersonaRol() {
    }

    public long getPersonaRolId() {
        return personaRolId;
    }

    public void setPersonaRolId(long personaRolId) {
        this.personaRolId = personaRolId;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}

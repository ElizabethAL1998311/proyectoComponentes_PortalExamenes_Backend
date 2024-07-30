package com.example.proyectocomponentesbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "tbl_persona_apadillale_earaias")
public class Persona implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", length = 60, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 60, nullable = false)
    private String password;

    @Column(name = "nombre", length = 60, nullable = false)
    private String nombre;

    @Column(name = "identificacion", length = 60, nullable = false)
    private String identificacion;

    @Column(name = "apellido", length = 60, nullable = false)
    private String apellido;

    @Column(name = "correo", length = 60, nullable = false, unique = true)
    private String correoElectronico;

    @Column(name = "enable", nullable = false)
    private boolean enable = true;

    private String perfil;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "persona")
    @JsonIgnore
    private Set<PersonaRol> usuarioRol = new HashSet<>();

    public Persona() {
    }

    public Persona(long id, String username, String password, String nombre, String identificacion, String apellido, String correoElectronico, boolean enable, String perfil, Set<PersonaRol> usuarioRol) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.enable = enable;
        this.perfil = perfil;
        this.usuarioRol = usuarioRol;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authority> autoridades = new HashSet<>();
        this.usuarioRol.forEach(usuarioRol -> {
            autoridades.add(new Authority(usuarioRol.getRol().getRolNombre()));
        });
        return autoridades;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Set<PersonaRol> getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(Set<PersonaRol> usuarioRol) {
        this.usuarioRol = usuarioRol;
    }
}
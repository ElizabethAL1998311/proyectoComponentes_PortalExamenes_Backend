package com.example.proyectocomponentesbackend;

import com.example.proyectocomponentesbackend.excepciones.UsuarioFoundException;
import com.example.proyectocomponentesbackend.model.Persona;
import com.example.proyectocomponentesbackend.model.PersonaRol;
import com.example.proyectocomponentesbackend.model.Rol;
import com.example.proyectocomponentesbackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ProyectoComponentesBackendApplication implements CommandLineRunner {

    @Autowired
    private PersonaService personaService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public static void main(String[] args) {
        SpringApplication.run(ProyectoComponentesBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       /* try{
        Persona persona = new Persona();

        persona.setUsername("Eli");
        persona.setPassword(bCryptPasswordEncoder.encode("12345"));
        persona.setNombre("Elizabeth");
        persona.setApellido("Arias");
        persona.setIdentificacion("702360999");
        persona.setCorreoElectronico("Eli1998@gmail.com");
        persona.setPerfil("foto.png");

        Rol rol = new Rol();
        rol.setId(1L);
        rol.setRolNombre("ADMI");

        Set<PersonaRol> personaRoles = new HashSet<>();
        PersonaRol personaRol = new PersonaRol();
        personaRol.setRol(rol);
        personaRol.setPersona(persona);
        personaRoles.add(personaRol);

        Persona personaGuardado = personaService.guardarPersona(persona,personaRoles);
        System.out.println(personaGuardado.getUsername());
        }catch (UsuarioFoundException exception){
            exception.printStackTrace();
        }*/

    }
}

package com.spring.crud.crudspring.controller;

import java.util.List;

import com.spring.crud.crudspring.model.Usuarios;
import com.spring.crud.crudspring.repository.UsuariosRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RestController
@RequestMapping("/login")
public class LoginController {

    private UsuariosRepository repository;

    LoginController(UsuariosRepository usuariosRepository) {
        this.repository = usuariosRepository;
    }

    @GetMapping
    public List<Usuarios> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Usuarios> create(@RequestBody Usuarios usuarios) {
    	List<Usuarios> users = repository.findAll();
    	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String reqUsername = usuarios.getUsername();
    	String reqPass = usuarios.getPassword();

    	for (Usuarios other : users) {
    		String otherUsername = other.getUsername();
    		String otherPass = other.getPassword();

    		if( reqUsername != null && otherPass != null && reqUsername.equals(otherUsername) 
    				&& passwordEncoder.matches(reqPass, otherPass)  ) {
        		System.out.println("entrou no ifffff");
    			return ResponseEntity.ok().body(other);
    		}
    	}
    	
    	return ResponseEntity.notFound().build();
    }
}

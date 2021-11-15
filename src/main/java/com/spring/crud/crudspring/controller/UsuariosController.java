package com.spring.crud.crudspring.controller;

import java.security.SecureRandom;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private UsuariosRepository repository;

    UsuariosController(UsuariosRepository usuariosRepository) {
        this.repository = usuariosRepository;
    }

    @GetMapping
    public List<Usuarios> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Usuarios> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuarios create(@RequestBody Usuarios usuarios) {
    	String pass = usuarios.getPassword();
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	String hashedPassword = passwordEncoder.encode(pass);
    	usuarios.setPassword(hashedPassword);
        return repository.save(usuarios);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<Usuarios> update(@PathVariable("id") long id, @RequestBody Usuarios usuarios) {
        
        return repository.findById(id).map(record -> {
            record.setId(id);
            record.setUsername(usuarios.getUsername());
            record.setEmail(usuarios.getEmail());
            Usuarios updated = repository.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = { "/{id}" })
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id).map(record -> {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}

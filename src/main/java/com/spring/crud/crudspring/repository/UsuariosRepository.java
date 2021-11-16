package com.spring.crud.crudspring.repository;

import com.spring.crud.crudspring.model.Usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

	Usuarios findByUsername(String username); 
}

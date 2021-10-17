package com.spring.crud.crudspring.repository;

import com.spring.crud.crudspring.model.Produtos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> { }

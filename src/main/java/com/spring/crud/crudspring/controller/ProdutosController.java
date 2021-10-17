package com.spring.crud.crudspring.controller;

import java.util.List;

import com.spring.crud.crudspring.model.Produtos;
import com.spring.crud.crudspring.repository.ProdutosRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private ProdutosRepository repository;

    ProdutosController(ProdutosRepository produtosRepository) {
        this.repository = produtosRepository;
    }

    @GetMapping
    public List<Produtos> findAll() {
        return repository.findAll();
    }

    @GetMapping(path = { "/{id}" })
    public ResponseEntity<Produtos> findById(@PathVariable long id) {
        return repository.findById(id).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produtos create(Produtos produtos) {
        return repository.save(produtos);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody ResponseEntity<Produtos> update(@PathVariable("id") long id, Produtos produtos) {
        
        return repository.findById(id).map(record -> {
            record.setDescricao(produtos.getDescricao());
            record.setPreco(produtos.getPreco());
            Produtos updated = repository.save(record);
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

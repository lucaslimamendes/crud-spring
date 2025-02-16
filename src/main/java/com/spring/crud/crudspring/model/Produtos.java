package com.spring.crud.crudspring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Produtos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String preco;
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getDescricao() {
    	return descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao != null ? descricao : this.descricao;
    }
    
    public String getPreco() {
    	return preco;
    }
    
    public void setPreco(String preco) {
        this.preco = preco != null ? preco : this.preco;
    }
}

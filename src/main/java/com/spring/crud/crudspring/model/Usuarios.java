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

public class Usuarios {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    
    public Long getId() {
    	return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
    	return username;
    }
    
    public void setUsername(String username) {
        this.username = username != null ? username : this.username;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
        this.email = email != null ? email : this.email;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}

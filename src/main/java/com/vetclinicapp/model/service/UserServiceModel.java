package com.vetclinicapp.model.service;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;

public class UserServiceModel {

    private Long id;
    private String username;

    private String password;

    public UserServiceModel() {
    }


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
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

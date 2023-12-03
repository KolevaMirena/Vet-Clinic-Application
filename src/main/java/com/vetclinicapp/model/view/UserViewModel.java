package com.vetclinicapp.model.view;

import com.vetclinicapp.model.entity.Role;

import java.util.List;

public class UserViewModel {

    private Long id;

    private String username;

    private List<Role> userRoles;


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

    public List<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.userRoles = userRoles;
    }
}

package com.vetclinicapp.model.view;

import com.vetclinicapp.model.entity.Role;
import org.apache.juli.logging.Log;

import java.util.List;

public class UserRoleViewModel {

    private Log id;

    private String username;

    private List<Role> roles;

    public Log getId() {
        return id;
    }

    public void setId(Log id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}

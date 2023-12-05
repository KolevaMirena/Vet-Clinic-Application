package com.vetclinicapp.model.dto;

import com.vetclinicapp.model.enums.UserRoleEnum;
import jakarta.validation.constraints.NotNull;

public class UserRoleBindingModel {


    @NotNull(message = "Please, choose user!")
    String username;

    @NotNull(message = "Please, choose role!")
    UserRoleEnum role;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }
}

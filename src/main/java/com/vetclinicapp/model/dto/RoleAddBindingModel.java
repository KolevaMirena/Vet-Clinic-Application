package com.vetclinicapp.model.dto;

import jakarta.validation.constraints.NotBlank;

public class RoleAddBindingModel {

    @NotBlank(message = "Please, choose role!")
    String roleName;


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

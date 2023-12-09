package com.vetclinicapp.model.dto;


import jakarta.validation.constraints.NotNull;

public class UserChangeUsernameBindingModel {

    @NotNull(message = "Please, enter new username!")
    private String newName;

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}

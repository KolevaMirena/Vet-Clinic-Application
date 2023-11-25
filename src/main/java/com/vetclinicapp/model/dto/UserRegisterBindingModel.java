package com.vetclinicapp.model.dto;
import jakarta.validation.constraints.Size;

public class UserRegisterBindingModel {


    @Size(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;


    @Size(min = 3, max= 20, message = "Password length must be between 3 and 20 characters!")
    private String password;


    private String confirmPassword;


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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}

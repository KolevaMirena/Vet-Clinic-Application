package com.vetclinicapp.model.dto;


import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class OwnerRegisterBindingModel {

    @NotNull
    @Size(min =3, max = 20, message = "Owner name length should be between 3 and 20 characters!")
    private String name;


    @NotBlank(message = "Owner phone field could not be blank!")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number should contains only numbers!")
    @Size(min = 10, max = 10, message = "Owner phone length should be exactly 10 digits!")
    @Column(nullable = false)
    private String phone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

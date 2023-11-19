package com.vetclinicapp.model.view;

import com.vetclinicapp.model.enums.VetSpecialtyEnum;

import static org.springframework.util.StringUtils.replace;


public class VetViewModel {

    private Long id;
    private String firstName;
    private String lastName;
    private String specialtyEnum;

    public VetViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialtyEnum() {
        return replace(specialtyEnum, "_", " ").toLowerCase();
    }

    public void setSpecialtyEnum(String specialtyEnum) {
        this.specialtyEnum = specialtyEnum;
    }
}

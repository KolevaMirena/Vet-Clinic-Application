package com.vetclinicapp.model.service;


public class OwnerServiceModel {


    private Long id;
    private String name;
    private String phone;

    public OwnerServiceModel() {
    }

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

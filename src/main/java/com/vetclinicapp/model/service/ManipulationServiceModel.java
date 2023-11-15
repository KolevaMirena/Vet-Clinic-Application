package com.vetclinicapp.model.service;

import com.vetclinicapp.model.enums.ManipulationTypeEnum;


import java.math.BigDecimal;

public class ManipulationServiceModel {

    private Long id;

    private String name;
    private ManipulationTypeEnum type;
    private String description;
    private BigDecimal price;

    public ManipulationServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManipulationTypeEnum getType() {
        return type;
    }

    public void setType(ManipulationTypeEnum type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}

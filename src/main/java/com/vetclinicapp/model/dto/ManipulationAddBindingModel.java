package com.vetclinicapp.model.dto;

import com.vetclinicapp.model.entity.ManipulationType;
import com.vetclinicapp.model.enums.ManipulationTypeEnum;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class ManipulationAddBindingModel {


    @NotBlank(message = "Manipulation name is mandatory!")
    private String name;


    @NotNull(message = "Type field could not be blank. Please, choose type!")
    private ManipulationTypeEnum type;

    @NotBlank(message = "Manipulation description is mandatory!")
    private String description;


    @Positive(message = "Price should be a positive number!")
    @NotNull(message = "Please, add manipulation price!")
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public ManipulationTypeEnum getType() {
        return type;
    }

    public void setType(ManipulationTypeEnum type) {
        this.type = type;
    }
}

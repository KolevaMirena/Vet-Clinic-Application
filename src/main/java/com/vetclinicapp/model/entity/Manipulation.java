package com.vetclinicapp.model.entity;


import com.vetclinicapp.model.enums.ManipulationTypeEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


@Entity
@Table(name = "manipulations")
public class Manipulation extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String name;


    @Enumerated(EnumType.STRING)
    @NotNull
    private ManipulationTypeEnum type;


    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;



    public Manipulation(){
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

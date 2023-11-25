package com.vetclinicapp.model.dto;

import com.vetclinicapp.model.enums.ProductTypeEnum;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class ProductAddBindingModel {

    @Size(min = 10, max = 50, message = "Product name length should be between 10 and 50 characters!")
    private String name;


    @NotNull(message = "Type field could not be empty. Please, choose type!")
    private ProductTypeEnum type;

    @NotNull(message = "Product price filed could not be empty!")
    @Min(value = 1, message = "Product price should be equal or greater than 1!")
    private BigDecimal price;

    @NotNull(message = "Product quantity filed could not be empty!")
    @Min(value = 1, message = "Product quantity should be equal or greater than 1!")
    private Long quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductTypeEnum getType() {
        return type;
    }

    public void setType(ProductTypeEnum type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

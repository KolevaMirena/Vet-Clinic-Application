package com.vetclinicapp.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ProductSellBindingModel {


    @NotNull(message = "Product name field could not be empty!")
    private String productName;

    @NotNull(message = "Pet name field could not be empty!")
    private String petName;


    @Min(value = 1, message = "Product quantity should be at least 1!")
    @NotNull(message = "Quantity filed could not be empty!")
    private Long quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}

package com.vetclinicapp.model.view;
import com.vetclinicapp.model.enums.ProductTypeEnum;
import java.math.BigDecimal;

public class ProductViewModel {


    private String name;
    private ProductTypeEnum type;
    private BigDecimal price;
    private Long quantity;

    public ProductViewModel() {
    }


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

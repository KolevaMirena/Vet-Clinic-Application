package com.vetclinicapp.model.view;
import com.vetclinicapp.model.enums.ProductTypeEnum;
import java.math.BigDecimal;

import static org.springframework.util.StringUtils.replace;

public class ProductViewModel {


    private String name;
    private String type;
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

    public String getType() {
        return replace(type, "_", " ").toLowerCase();
    }

    public void setType(String type) {
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

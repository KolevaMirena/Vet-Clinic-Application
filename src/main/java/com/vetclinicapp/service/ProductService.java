package com.vetclinicapp.service;

import com.vetclinicapp.model.dto.ProductAddBindingModel;
import com.vetclinicapp.model.dto.ProductSellBindingModel;
import com.vetclinicapp.model.entity.Product;
import com.vetclinicapp.model.service.ProductServiceModel;
import com.vetclinicapp.model.view.ProductViewModel;

import java.util.List;

public interface ProductService {
    boolean addProduct(ProductServiceModel productServiceModel, ProductAddBindingModel productAddBindingModel);

    List<Product> getAllAvailableProduct();

    boolean sellProduct(ProductSellBindingModel productSellBindingModel);

    List<ProductViewModel> getAllProductsOrderByType();

    void cleanUpUnavailableProducts();

}

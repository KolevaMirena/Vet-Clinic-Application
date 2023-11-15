package com.vetclinicapp.repository;


import com.vetclinicapp.model.entity.Product;
import com.vetclinicapp.model.enums.ProductTypeEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {

    Product findByName(String name);


    @Query(nativeQuery = true, value = "SELECT * FROM products where quantity > 0")
    List<Product> getAllAvailableProducts();

    @Query(nativeQuery = true, value = "SELECT * FROM products order by type")
    List<Product> getProductsOrderByType();
}

package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.dto.PetRegisterBindingModel;
import com.vetclinicapp.model.dto.ProductAddBindingModel;
import com.vetclinicapp.model.dto.ProductSellBindingModel;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.entity.Product;
import com.vetclinicapp.model.enums.PetTypeEnum;
import com.vetclinicapp.model.enums.ProductTypeEnum;
import com.vetclinicapp.model.service.OwnerServiceModel;
import com.vetclinicapp.model.service.PetServiceModel;
import com.vetclinicapp.model.service.ProductServiceModel;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.repository.ProductRepository;
import com.vetclinicapp.service.OwnerService;
import com.vetclinicapp.service.PetService;
import com.vetclinicapp.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductServiceImplTest {


    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PetService petService;

    @Autowired
    private PetRepository petRepository;



    @Autowired
    private OwnerService ownerService;

    @Autowired
    private OwnerRepository ownerRepository;


    @BeforeEach
    public void  setUp(){
        productRepository.deleteAll();
        petRepository.deleteAll();
        ownerRepository.deleteAll();
    }

    @AfterEach
    public void  tearDown(){
        productRepository.deleteAll();
        petRepository.deleteAll();
        ownerRepository.deleteAll();
    }


    @Test
    public void getAllProductsEmptyTest(){

        assertEquals(0, productRepository.count());

    }



    @Test
    public void addProductTest(){

        ProductServiceModel productServiceModel = new ProductServiceModel();
        productServiceModel.setId(1L);
        productServiceModel.setName("Product123");
        productServiceModel.setQuantity(20L);
        productServiceModel.setType(ProductTypeEnum.FOOD);
        productServiceModel.setPrice(BigDecimal.valueOf(50));

        ProductAddBindingModel productAddBindingModel = new ProductAddBindingModel();
        productAddBindingModel.setName("Product123");
        productAddBindingModel.setPrice(BigDecimal.valueOf(50));
        productAddBindingModel.setType(ProductTypeEnum.FOOD);
        productAddBindingModel.setQuantity(20L);


        productService.addProduct(productServiceModel, productAddBindingModel);


        assertEquals(1, productRepository.count());

    }

    @Test
    public void sellProductTest(){

        OwnerServiceModel owner = new OwnerServiceModel();
        owner.setName("Mira");
        owner.setPhone("0898718879");

        ownerService.registerOwner(owner);

        PetServiceModel newPet = new PetServiceModel();
        newPet.setName("Kari");
        newPet.setPetType(PetTypeEnum.DOG);
        newPet.setAge(1L);

        PetRegisterBindingModel petRegisterBindingModel = new PetRegisterBindingModel();
        petRegisterBindingModel.setName("Kari");
        petRegisterBindingModel.setPetType(PetTypeEnum.DOG);
        petRegisterBindingModel.setAge(1L);
        petRegisterBindingModel.setOwnerPhone("0898718879");

        petService.registerPet(newPet, petRegisterBindingModel);

        ProductServiceModel productServiceModel = new ProductServiceModel();
        productServiceModel.setId(1L);
        productServiceModel.setName("Product123");
        productServiceModel.setQuantity(20L);
        productServiceModel.setType(ProductTypeEnum.FOOD);
        productServiceModel.setPrice(BigDecimal.valueOf(50));

        ProductAddBindingModel productAddBindingModel = new ProductAddBindingModel();
        productAddBindingModel.setName("Product123");
        productAddBindingModel.setPrice(BigDecimal.valueOf(50));
        productAddBindingModel.setType(ProductTypeEnum.FOOD);
        productAddBindingModel.setQuantity(20L);

        productService.addProduct(productServiceModel, productAddBindingModel);

        ProductSellBindingModel productSellBindingModel = new ProductSellBindingModel();
        productSellBindingModel.setProductName("Product123");
        productSellBindingModel.setQuantity(2L);
        productSellBindingModel.setPetName("Kari");


        productService.sellProduct(productSellBindingModel);

        Product product123 = productRepository.findByName("Product123");

        assertEquals(18, product123.getQuantity() );


    }

    @Test
    public void getAllProductsTest(){

        OwnerServiceModel owner = new OwnerServiceModel();
        owner.setName("Mira");
        owner.setPhone("0898718879");

        ownerService.registerOwner(owner);

        PetServiceModel newPet = new PetServiceModel();
        newPet.setName("Kari");
        newPet.setPetType(PetTypeEnum.DOG);
        newPet.setAge(1L);

        PetRegisterBindingModel petRegisterBindingModel = new PetRegisterBindingModel();
        petRegisterBindingModel.setName("Kari");
        petRegisterBindingModel.setPetType(PetTypeEnum.DOG);
        petRegisterBindingModel.setAge(1L);
        petRegisterBindingModel.setOwnerPhone("0898718879");

        petService.registerPet(newPet, petRegisterBindingModel);

        ProductServiceModel productServiceModel = new ProductServiceModel();
        productServiceModel.setId(1L);
        productServiceModel.setName("Product123");
        productServiceModel.setQuantity(20L);
        productServiceModel.setType(ProductTypeEnum.FOOD);
        productServiceModel.setPrice(BigDecimal.valueOf(50));

        ProductAddBindingModel productAddBindingModel = new ProductAddBindingModel();
        productAddBindingModel.setName("Product123");
        productAddBindingModel.setPrice(BigDecimal.valueOf(50));
        productAddBindingModel.setType(ProductTypeEnum.FOOD);
        productAddBindingModel.setQuantity(20L);

        productService.addProduct(productServiceModel, productAddBindingModel);



        assertEquals(1, productRepository.count());


    }



}

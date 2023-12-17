package com.vetclinicapp.service.impl;


import com.vetclinicapp.model.dto.ProductAddBindingModel;
import com.vetclinicapp.model.dto.ProductSellBindingModel;
import com.vetclinicapp.model.entity.PetProduct;
import com.vetclinicapp.model.entity.Product;
import com.vetclinicapp.model.service.ProductServiceModel;
import com.vetclinicapp.model.view.ProductViewModel;
import com.vetclinicapp.repository.PetProductRepository;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.repository.ProductRepository;
import com.vetclinicapp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {


    private  final ProductRepository productRepository;

    private final PetRepository petRepository;

    private final ModelMapper modelMapper;

    private final PetProductRepository petProductRepository;

    public ProductServiceImpl(ProductRepository productRepository, PetRepository petRepository, ModelMapper modelMapper, PetProductRepository petProductRepository) {
        this.productRepository = productRepository;
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
        this.petProductRepository = petProductRepository;
    }

    @Override
    public boolean addProduct(ProductServiceModel productServiceModel, ProductAddBindingModel productAddBindingModel) {


       Product existedProduct = this.productRepository.findByName(productAddBindingModel.getName());

       if(existedProduct != null){

           existedProduct.setQuantity(existedProduct.getQuantity() + productAddBindingModel.getQuantity());

          return false;
      }

        Product product = modelMapper.map(productServiceModel, Product.class);


        this.productRepository.save(product);

        return true;
    }

    @Override
    public List<Product> getAllAvailableProduct() {
        return this.productRepository.getAllAvailableProducts();
    }

    @Override
    public boolean sellProduct(ProductSellBindingModel productSellBindingModel) {

        Product currentProduct = this.productRepository.findByName(productSellBindingModel.getProductName());
        long quantity = productSellBindingModel.getQuantity();
        Long currentProductQuantity = currentProduct.getQuantity();
        currentProduct.setQuantity(currentProductQuantity - quantity);
        this.productRepository.save(currentProduct);


        PetProduct byPetNameAndProductName = this.petProductRepository
                .findByPetNameAndProductName(productSellBindingModel.getPetName(), productSellBindingModel.getProductName());

        if (byPetNameAndProductName != null) {
            byPetNameAndProductName.setQuantity(byPetNameAndProductName.getQuantity() + productSellBindingModel.getQuantity());
            this.petProductRepository.save(byPetNameAndProductName);
        } else {

            PetProduct petProduct = modelMapper.map(productSellBindingModel, PetProduct.class);
            this.petProductRepository.save(petProduct);

        }

        return true;
    }

    @Override
    public List<ProductViewModel> getAllProductsOrderByType() {

      return this.productRepository.getProductsOrderByType()
              .stream().map(product->
                            modelMapper.map(product, ProductViewModel.class)
             ).collect(Collectors.toList());

    }

    @Override
    public void cleanUpUnavailableProducts() {

        this.productRepository.cleanUpUnavailableProducts();

    }
}

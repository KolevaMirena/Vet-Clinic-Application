package com.vetclinicapp.controller;


import com.vetclinicapp.model.dto.ProductAddBindingModel;
import com.vetclinicapp.model.dto.ProductSellBindingModel;
import com.vetclinicapp.model.entity.Pet;
import com.vetclinicapp.model.entity.Product;
import com.vetclinicapp.model.service.ProductServiceModel;
import com.vetclinicapp.service.PetService;
import com.vetclinicapp.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {


    private final ProductService productService;
    private final PetService petService;

    private  ModelMapper modelMapper;


    public ProductController(ProductService productService, PetService petService, ModelMapper modelMapper) {
        this.productService = productService;
        this.petService = petService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/product/add")
    public ModelAndView addProduct(@ModelAttribute("productAddBindingModel") ProductAddBindingModel productAddBindingModel) {
        return new ModelAndView("product-add");
    }


    @PostMapping("/product/add")
    public ModelAndView addProduct(@ModelAttribute("productAddBindingModel") @Valid ProductAddBindingModel productAddBindingModel,
                                        BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return new ModelAndView("product-add");

        }

        boolean successfulAdded = this.productService.addProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class),
                                                                  productAddBindingModel);



        if(!successfulAdded){
            ModelAndView modelAndView = new ModelAndView("product-add");
            modelAndView.addObject("hasProductAddError", true);
            return modelAndView;
        }


        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/product/sell")
    public ModelAndView sellProduct(@ModelAttribute("productSellBindingModel") ProductSellBindingModel productSellBindingModel) {

        ModelAndView modelAndView = new ModelAndView("product-sell");


        List<Pet> allPets = this.petService.getAllPets();
        List<Product> productList = this.productService.getAllAvailableProduct();


        modelAndView.addObject("allPets", allPets);
        modelAndView.addObject("productList", productList);


        return modelAndView;

    }


    @PostMapping("/product/sell")
    public ModelAndView sellProduct(@ModelAttribute("productSellBindingModel") @Valid ProductSellBindingModel productSellBindingModel,
                                        BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            return new ModelAndView("product-sell");

        }

        boolean successfulSold= this.productService.sellProduct(productSellBindingModel);

        if(!successfulSold){
            ModelAndView modelAndView = new ModelAndView("product-sell");
            modelAndView.addObject("hasProductSellError", true);
            return modelAndView;
        }


        return new ModelAndView("redirect:/home");
    }
}

package com.vetclinicapp.controller;

import com.vetclinicapp.model.view.PetViewModel;
import com.vetclinicapp.model.view.ProductViewModel;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.service.PetService;
import com.vetclinicapp.service.ProductService;
import com.vetclinicapp.service.impl.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;
    private final LoggedUser loggedUser;
    private final PetService petService;

    public HomeController(ProductService productService, LoggedUser loggedUser, PetRepository petRepository, PetService petService) {
        this.productService = productService;
        this.loggedUser = loggedUser;
        this.petService = petService;
    }

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){

        if(!loggedUser.isLogged()){
            return new ModelAndView("redirect:/");

        }

        return new ModelAndView("home");
    }


    @GetMapping("/products/available")
    public ModelAndView availableProducts(){

        ModelAndView modelAndView =new ModelAndView("products-available");

        List<ProductViewModel> allProductsOrderByType = this.productService.getAllProductsOrderByType();

        modelAndView.addObject("allProductsOrderByType", allProductsOrderByType);

        return modelAndView;
    }

    @GetMapping("/pets/all")
   public ModelAndView allPets(){

        ModelAndView modelAndView = new ModelAndView("pets-all");

       List<PetViewModel> allPets = this.petService.getAllPetsOrderByName();

       modelAndView.addObject("allPets", allPets);

        return modelAndView;
   }




    //vet/details

    //owner/details




}

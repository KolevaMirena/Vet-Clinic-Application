package com.vetclinicapp.controller;

import com.vetclinicapp.model.view.OwnerViewModel;
import com.vetclinicapp.model.view.PetViewModel;
import com.vetclinicapp.model.view.ProductViewModel;
import com.vetclinicapp.model.view.VetViewModel;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.service.OwnerService;
import com.vetclinicapp.service.PetService;
import com.vetclinicapp.service.ProductService;
import com.vetclinicapp.service.VetService;
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
    private final VetService vetService;
    private final OwnerService ownerService;

    public HomeController(ProductService productService, LoggedUser loggedUser, PetRepository petRepository, PetService petService, VetService vetService, OwnerRepository ownerRepository, OwnerService ownerService) {
        this.productService = productService;
        this.loggedUser = loggedUser;
        this.petService = petService;
        this.vetService = vetService;
        this.ownerService = ownerService;

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

    @GetMapping("/vets/all")
    public ModelAndView allVets(){

        ModelAndView modelAndView = new ModelAndView("vets-all");

        List<VetViewModel> allVetsOrderByName = this.vetService.getAllVetsOrderByName();

        modelAndView.addObject("allVetsOrderByName", allVetsOrderByName);

        return modelAndView;
    }

    @GetMapping("/owners/all")
    public ModelAndView allOwners(){

        ModelAndView modelAndView = new ModelAndView("owners-all");

        List<OwnerViewModel> allOwnersOrderByName = this.ownerService.getAllOwnersOrderByName();

        modelAndView.addObject("allOwnersOrderByName", allOwnersOrderByName);

        return modelAndView;
    }


}

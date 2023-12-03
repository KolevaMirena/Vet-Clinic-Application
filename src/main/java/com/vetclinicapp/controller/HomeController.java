package com.vetclinicapp.controller;

import com.vetclinicapp.model.dto.RoleAddBindingModel;
import com.vetclinicapp.model.entity.Role;
import com.vetclinicapp.model.view.*;
import com.vetclinicapp.repository.OwnerRepository;
import com.vetclinicapp.repository.PetRepository;
import com.vetclinicapp.service.*;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final ProductService productService;
   // private final LoggedUser loggedUser;
    private final PetService petService;
    private final VetService vetService;
    private final OwnerService ownerService;
    private final UserService userService;
    private final RoleService roleService;


    public HomeController(ProductService productService, PetRepository petRepository, PetService petService, VetService vetService, OwnerRepository ownerRepository, OwnerService ownerService, UserService userService, RoleService roleService) {
        this.productService = productService;

        this.petService = petService;
        this.vetService = vetService;
        this.ownerService = ownerService;

        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){

       // if(!loggedUser.isLogged()){
           // return new ModelAndView("redirect:/");
       // }
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

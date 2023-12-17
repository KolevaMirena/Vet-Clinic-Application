package com.vetclinicapp.service.schedulers;


import com.vetclinicapp.service.ProductService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UnavailableProductsCleanUpScheduler {

    private final ProductService productService;

    public UnavailableProductsCleanUpScheduler(ProductService productService) {
        this.productService = productService;
    }


    @Scheduled(cron = "* 0 4 * * *")
    public void productCleanUp(){

        this.productService.cleanUpUnavailableProducts();

        System.out.println("schedule");
    }


}

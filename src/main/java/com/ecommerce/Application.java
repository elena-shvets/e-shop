package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ComponentScan({"com.ecommrce"})
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/products").setViewName("created_prod");
//    }


}

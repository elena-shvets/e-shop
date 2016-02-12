package com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class {@link Application}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 05.02.16
 */

@SpringBootApplication
@ComponentScan({"com.ecommerce"})
public class Application extends SpringBootServletInitializer {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

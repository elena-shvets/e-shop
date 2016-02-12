package com.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class {@link GreetingController}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 04.02.16
 */
@Controller
@RequestMapping("/hello")
public class GreetingController {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String showMainPage() {
        return "site.greeting";
    }
}

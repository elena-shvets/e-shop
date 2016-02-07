package com.ecommerce.controllers;

import com.ecommerce.dto.ProductDto;
import com.ecommerce.dto.UserDto;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class {@link com.ecommerce.controllers.UserController}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 15.10.15
 */
@Controller
@RequestMapping("/ecommerce")
public class EcommerceController {
    private static final Logger LOG = Logger.getLogger(EcommerceController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    /**
     * Method that create and add an object to the database
     * and return response with error message if something wrong. If everything ok -
     * response with success message
     *
     * @param userDto
     * @return result
     * *
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        if (userDto == null) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userService.saveUser(user);
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    /**
     * Method that receives all objects from the database
     * and return response with error message if something wrong. If everything ok -
     * returns list of objects
     *
     * @return formed result
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (CollectionUtils.isEmpty(users)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(users, HttpStatus.OK);

    }

    /**
     * Method that receives an object by id from the database
     * and return response with error message if something wrong. If everything ok -
     * response with success message
     *
     * @param userId
     * @return result
     * *
     */
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getOneById(@PathVariable Long userId) {
        if (!userService.checkUserForExistById(userId)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(userService.findUserById(userId), HttpStatus.OK);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        if (productDto == null) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        product.setDescription(productDto.getDescription());
        productService.save(product);
        return new ResponseEntity<Product>(HttpStatus.OK);
    }
}

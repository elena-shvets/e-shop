package com.ecommerce.controllers;

import com.ecommerce.dto.UserDto;
import com.ecommerce.model.User;
import com.ecommerce.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class {@link UserController}
 * Handles user - related requests
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 15.10.15
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOG = Logger.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    /**
     * Method that shows the form for adding/login a user
     *
     * @return result page
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "view.login_form";
    }

    /**
     * Method that create and add an object to the database
     * and return response with error message if something wrong. If everything ok -
     * response with success message
     *
     * @param userDto
     * @return result
     * *
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String createUser(@ModelAttribute UserDto userDto, Model model) {
        if (userDto == null) {
            LOG.info("User must not be null");
        }
        User user = userService.findUserByEmail(userDto.getEmail());
        if (user != null) {
            return "view.all_products";
        }

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setPassword(userDto.getPassword());
        userService.saveUser(newUser);
        return "view.join_user";
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

    /**
     * Method that validates data
     * return "false" - if the data is not valid or missing
     * If everything ok - return "true"
     *
     * @param userDto
     * @return result
     */
    public boolean isValid(UserDto userDto) {
        if (userDto.getEmail() == null || userDto.getPassword() == null) {
            return false;
        }
        return true;
    }

}

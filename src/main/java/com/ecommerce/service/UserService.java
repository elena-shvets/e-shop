package com.ecommerce.service;

import com.ecommerce.model.User;

import java.util.List;

/**
 * Class {@link UserService}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 14.10.15
 */

public interface UserService {

    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    User findUserByEmail(String email);
    User findUserById(Long id);
    List<User> getAllUsers();
    boolean checkUserForExistById(Long id);
}

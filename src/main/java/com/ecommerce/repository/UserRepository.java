package com.ecommerce.repository;

import com.ecommerce.model.User;

import java.util.List;


/**
 * Class {@link com.ecommerce.repository.UserRepository}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 08.10.15
 */

public interface UserRepository {

    User saveUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    User findUserByEmail(String email);
    User findUserById(Long id);
    List<User> getAllUsers();
    boolean checkUserForExistById(Long id);

}
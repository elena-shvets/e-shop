package com.ecommerce.service;

import com.ecommerce.model.User;

import java.util.List;

/**
 * Service layer for {@link User} business models
 * Provides transactions for repository
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 05.02.16
 */
public interface UserService {

    /**
     * Constructs entity
     * Persists new entity
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * Updates given entity in database (if exists)
     *
     * @param user entity to be persisted
     */
    void updateUser(User user);

    /**
     * Removes given entity from database
     *
     * @param user
     */
    void deleteUser(User user);

    /**
     * Searches for {@link User} entity with a given email in database
     *
     * @param email entity identifier
     * @return found entity, or NULL
     */
    User findUserByEmail(String email);

    /**
     * Searches for {@link User} entity with a given id in database
     *
     * @param id entity identifier
     * @return found entity, or NULL
     */
    User findUserById(Long id);

    /**
     * @return every {@link User} entity, persisted in database
     */
    List<User> getAllUsers();

    /**
     * Checks whether there is an entity with a given email in the database
     *
     * @param email
     * @return
     */
    boolean isExistingEmail(String email);

    /**
     * Checks whether there is an entity with a given id in the database
     *
     * @param id
     * @return result(true or false)
     */
    boolean checkUserForExistById(Long id);

}

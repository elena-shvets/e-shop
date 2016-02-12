package com.ecommerce.service.impl;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserDao;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class {@link UserServiceImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 14.10.15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        userDao.saveUser(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExistingEmail(String email) {
        if (!userDao.isExistingEmail(email)){
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkUserForExistById(Long id) {
        if(!userDao.checkUserForExistById(id)){
            return false;
        }
        return true;
    }

}

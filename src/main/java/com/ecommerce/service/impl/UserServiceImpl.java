package com.ecommerce.service.impl;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserDao;
import com.ecommerce.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Class {@link com.ecommerce.service.impl.UserServiceImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 14.10.15
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOG = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User must not be null");
        }
        return userDao.saveUser(user);
    }

    @Override
    public User updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);

    }

    @Override
    public User findUserByEmail(String email) {
        return userDao.findUserByEmail(email);
    }

    @Override
    public User findUserById(Long id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
}

    @Override
    public boolean checkUserForExistById(Long id) {
        if (!entityManager.contains(findUserById(id))) {
            return userDao.checkUserForExistById(id);
        }
        return true;
    }


}

package com.ecommerce.repository.impl;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Class {@link com.ecommerce.repository.impl.UserRepositoryImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 12.10.15
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private static final Logger LOG = Logger.getLogger(UserRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public User saveUser(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
        User removingUser = entityManager.find(User.class, user.getId());
        entityManager.remove(removingUser);

    }

    @Override
    public User findUserByEmail(String email) {
        return entityManager.find(User.class, email);
    }

    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        return query.getResultList();
    }

    @Override
    public boolean checkUserForExistById(Long id) {
        return entityManager.find(User.class, id) != null;
    }
}

package com.ecommerce.repository.impl;

import com.ecommerce.model.User;
import com.ecommerce.repository.UserDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Class {@link UserDaoImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 06.02.16
 */
@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteUser(User user) {
        User removingUser = entityManager.find(User.class, user.getId());
        entityManager.remove(removingUser);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User findUserByEmail(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email");
        query.setParameter("email", email);
        List<User> users = query.getResultList();
        if (!CollectionUtils.isEmpty(users)) {
            return users.get(0);
        }

        return null;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User findUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("FROM User");
        return (List<User>) query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isExistingEmail(String email) {
        return entityManager.find(User.class, email) != null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkUserForExistById(Long id) {
        return entityManager.find(User.class, id) != null;
    }
}

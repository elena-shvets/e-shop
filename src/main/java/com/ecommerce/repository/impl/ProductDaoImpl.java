package com.ecommerce.repository.impl;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductDao;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.List;

/**
 * Class {@link ProductDaoImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 04.02.16
 */
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Product product) {

        entityManager.persist(product);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Product product) {
        entityManager.merge(product);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> getAll() {
        Query query = entityManager.createQuery("from Product");
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product findOneById(Long id) {
        return entityManager.find(Product.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product findOneByTitle(String title) {
        return entityManager.find(Product.class, title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> findByCategory(Long categoryId) {
        List<Product> products = (List<Product>) entityManager.find(Product.class, categoryId);
        return products;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        Product removingProduct = entityManager.find(Product.class, id);
        entityManager.remove(removingProduct);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isProductExist(Long id) {
        return entityManager.contains(findOneById(id));
    }
}

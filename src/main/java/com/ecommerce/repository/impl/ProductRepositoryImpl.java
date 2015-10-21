package com.ecommerce.repository.impl;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
/**
 * Class {@link com.ecommerce.repository.impl.ProductRepositoryImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 16.10.15
 */
@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    private static final Logger LOG = Logger.getLogger(ProductRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        entityManager.persist(product);
        return product;
    }

    @Override
    public Product update(Product product) {
        entityManager.merge(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        Query query = entityManager.createQuery("from Product");
        return query.getResultList();
    }

    @Override
    public Product findOneById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product findOneByTitle(String title) {
        return entityManager.find(Product.class, title);
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        List<Product> products = (List<Product>) entityManager.find(Product.class, categoryId);
        return products;
    }

    @Override
    public void delete(Product product) {
        Product removingProduct = entityManager.find(Product.class, product.getId());
        entityManager.remove(removingProduct);
    }

    @Override
    public boolean isProductExist(Long id) {
        return entityManager.find(Product.class, id) != null;
    }
}

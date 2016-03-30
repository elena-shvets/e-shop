package com.ecommerce.repository.impl;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import java.util.Collection;
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
        int pageNumber = 1;
        int pageSize = 5;

        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        List <Product> products = query.getResultList();
        int totalResults = products.size();
        int totalPages = (int) Math.ceil(totalResults / pageSize);

        return products;
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
        Query query = entityManager.createQuery("SELECT p FROM Product p WHERE p.title= :title");
        query.setParameter("title", title);
        List<Product> products = query.getResultList();
        if (!CollectionUtils.isEmpty(products)) {
            return products.get(0);
        }
        return null;
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

    @Override
    public List<Product> getProductSortedByPrice() {
        Query query = entityManager.createQuery("SELECT p FROM Product p ORDER BY price, id");
        List<Product> products = query.getResultList();

        return products;
    }

    @Override
    public List<Product> getProductSortedByTitle() {
        Query query = entityManager.createQuery("SELECT p FROM Product p ORDER BY title, id");
        List<Product> products = query.getResultList();

        return products;
    }
}

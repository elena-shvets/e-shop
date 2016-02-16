package com.ecommerce.repository.impl;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Class {@link ProductCategoryDaoImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 04.02.16
 */
@Repository
@Transactional
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(ProductCategory productCategory) {
        entityManager.persist(productCategory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(ProductCategory productCategory) {
        entityManager.merge(productCategory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(ProductCategory productCategory) {
        ProductCategory removingProductCategory = entityManager.find(ProductCategory.class, productCategory.getId());
        entityManager.remove(removingProductCategory);

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductCategory foundOneById(Long id) {
        return entityManager.find(ProductCategory.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductCategory foundByTitle(String title) {
        Query query = entityManager.createQuery("SELECT pc FROM ProductCategory pc WHERE pc.title = :title");
        query.setParameter("title", title);
        List<ProductCategory> categories = query.getResultList();
        if (!CollectionUtils.isEmpty(categories)) {
            return categories.get(0);
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductCategory> getAll() {
        Query query = entityManager.createQuery("from ProductCategory");
        return query.getResultList();
    }
}

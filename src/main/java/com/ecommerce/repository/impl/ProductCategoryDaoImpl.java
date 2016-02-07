package com.ecommerce.repository.impl;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


/**
 * Class {@link com.ecommerce.repository.impl.ProductCategoryDaoImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 14.10.15
 */
@Repository
@Transactional
public class ProductCategoryDaoImpl implements ProductCategoryDao {

    private static final Logger LOG = Logger.getLogger(ProductDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        entityManager.persist(productCategory);
        return productCategory;
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        entityManager.merge(productCategory);
        return productCategory;
    }

    @Override
    public void delete(ProductCategory productCategory) {
        ProductCategory removingProductCategory = entityManager.find(ProductCategory.class, productCategory.getId());
        entityManager.remove(removingProductCategory);

    }

    @Override
    public ProductCategory foundOneById(Long id) {
        return entityManager.find(ProductCategory.class, id);
    }

    @Override
    public ProductCategory foundByTitle(String title) {
        return entityManager.find(ProductCategory.class, title);
    }

    @Override
    public List<ProductCategory> getAll() {
        Query query = entityManager.createQuery("from ProductCategory");
        return query.getResultList();
    }
}

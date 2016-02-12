package com.ecommerce.service.impl;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryDao;
import com.ecommerce.service.ProductCategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Class {@link ProductCategoryServiceImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 06.12.16
 */
@Service("productCategory")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private static final Logger LOG = Logger.getLogger(ProductCategoryServiceImpl.class);

    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(ProductCategory productCategory) {
        if (productCategory == null) {
            throw new IllegalArgumentException("ProductCategory must not be null");
        }
        productCategoryDao.save(productCategory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(ProductCategory productCategory) {
        productCategoryDao.update(productCategory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(ProductCategory productCategory) {
        productCategoryDao.delete(productCategory);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductCategory foundOneById(Long id) {
        return productCategoryDao.foundOneById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductCategory foundByTitle(String title) {
        return productCategoryDao.foundByTitle(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDao.getAll();
    }
}

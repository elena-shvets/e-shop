package com.ecommerce.service.impl;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryDao;
import com.ecommerce.service.ProductCategoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Class {@link com.ecommerce.service.impl.ProductCategoryServiceImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 14.10.15
 */
@Service("productCategory")
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private static final Logger LOG = Logger.getLogger(ProductCategoryServiceImpl.class);

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        if (productCategory == null) {
            throw new IllegalArgumentException("ProductCategory must not be null");
        }
        return productCategoryDao.save(productCategory);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return productCategoryDao.update(productCategory);
    }

    @Override
    public void delete(ProductCategory productCategory) {
        productCategoryDao.delete(productCategory);
    }

    @Override
    public ProductCategory foundOneById(Long id) {
        return productCategoryDao.foundOneById(id);
    }

    @Override
    public ProductCategory foundByTitle(String title) {
        return productCategoryDao.foundByTitle(title);
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDao.getAll();
    }
}

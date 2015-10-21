package com.ecommerce.service.impl;

import com.ecommerce.model.ProductCategory;
import com.ecommerce.repository.ProductCategoryRepository;
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
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        if (productCategory == null) {
            throw new IllegalArgumentException("ProductCategory must not be null");
        }
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory update(ProductCategory productCategory) {
        return productCategoryRepository.update(productCategory);
    }

    @Override
    public void delete(ProductCategory productCategory) {
        productCategoryRepository.delete(productCategory);
    }

    @Override
    public ProductCategory foundOneById(Long id) {
        return productCategoryRepository.foundOneById(id);
    }

    @Override
    public ProductCategory foundByTitle(String title) {
        return productCategoryRepository.foundByTitle(title);
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryRepository.getAll();
    }
}

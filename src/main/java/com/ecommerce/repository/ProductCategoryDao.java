package com.ecommerce.repository;

import com.ecommerce.model.ProductCategory;

import java.util.List;

/**
 * Class {@link ProductCategoryDao}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 14.10.15
 */
public interface ProductCategoryDao {

    ProductCategory save(ProductCategory productCategory);
    ProductCategory update(ProductCategory productCategory);
    void delete(ProductCategory productCategory);
    ProductCategory foundOneById(Long id);
    ProductCategory foundByTitle(String title);
    List<ProductCategory> getAll();
}

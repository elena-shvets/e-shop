package com.ecommerce.service;

import com.ecommerce.model.ProductCategory;

import java.util.List;


/**
 * Service layer for {@link ProductCategory} business models
 * Provides transactions for repository
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 06.02.16
 */

public interface ProductCategoryService {

    /**
     * Persists new entity
     *
     * @param productCategory
     */
    void save(ProductCategory productCategory);

    /**
     * Updates new entity
     *
     * @param productCategory
     */
    void update(ProductCategory productCategory);

    /**
     * Removes given entity from database
     *
     * @param productCategory
     */
    void delete(ProductCategory productCategory);

    /**
     * Searches for {@link ProductCategory} entity with a given id in database
     *
     * @param id entity identifier
     * @return found entity, or NULL
     */
    ProductCategory foundOneById(Long id);

    /**
     * Searches for {@link ProductCategory} entity with a given title in database
     *
     * @param title entity identifier
     * @return found entity, or NULL
     */
    ProductCategory foundByTitle(String title);

    /**
     * @return list with every {@link ProductCategory} entity, persisted in database
     */
    List<ProductCategory> getAll();
}

package com.ecommerce.repository;

import com.ecommerce.model.Product;

import java.util.List;

/**
 * DAO layer {@link Product} business model
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 06.02.16
 */

public interface ProductDao {

    /**
     * Persists new entity
     *
     * @param product
     */
    void save(Product product);

    /**
     * Updates new entity
     *
     * @param product
     */
    void update(Product product);

    /**
     * @return list with every {@link Product} entity, persisted in database
     */
    List<Product> getAll();

    /**
     * Searches for {@link Product} entity with a given id in database
     *
     * @param id entity identifier
     * @return found entity, or NULL
     */
    Product findOneById(Long id);

    /**
     * Searches for {@link Product} entity with a given title in database
     *
     * @param title entity identifier
     * @return found entity, or NULL
     */
    Product findOneByTitle(String title);

    /**
     * Searches for {@link Product} entity
     *
     * @param categoryId
     * @return list with every {@link Product} entity with a given title, persisted in database
     */
    List<Product> findByCategory(Long categoryId);

    /**
     * Removes given entity from database
     *
     * @param id entity to be removed
     */
    void deleteById(Long id);

    /**
     * Checks whether there is an entity with a given id in the database
     *
     * @param id
     * @return result(true or false)
     */
    boolean isProductExist(Long id);
}

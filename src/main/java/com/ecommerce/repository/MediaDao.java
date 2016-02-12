package com.ecommerce.repository;

import com.ecommerce.model.Media;

/**
 * DAO layer {@link Media}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 05.02.16
 */

public interface MediaDao {

    /**
     * Persists new entity
     *
     * @param media entity to be persisted
     */
    void save(Media media);

    /**
     * Updates entity
     *
     * @param media entity to be updated
     */
    void update(Media media);

    /**
     * Removes given entity from database
     *
     * @param media entity to be removed
     */
    void delete(Media media);


}

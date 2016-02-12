package com.ecommerce.service;

import com.ecommerce.model.Media;

/**
 * Service layer for {@link Media}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 07.02.16
 */

public interface MediaService {

    /**
     * Constructs entity
     * Persists new entity
     *
     * @param media
     */
    void save(Media media);

    /**
     * Updates given entity in database (if exists)
     *
     * @param media
     */
    void update(Media media);

    /**
     * Removes given entity from database
     *
     * @param media
     */
    void delete(Media media);
}

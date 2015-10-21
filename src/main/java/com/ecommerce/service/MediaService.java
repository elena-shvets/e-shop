package com.ecommerce.service;

import com.ecommerce.model.Media;

/**
 * Class {@link com.ecommerce.repository.impl.UserRepositoryImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 16.10.15
 */

public interface MediaService {

    Media save(Media media);
    Media update(Media media);
    void delete(Media media);
}

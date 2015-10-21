package com.ecommerce.repository;

import com.ecommerce.model.Media;

/**
 * Class {@link com.ecommerce.repository.MediaRepository}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 16.10.15
 */

public interface MediaRepository {

    Media save(Media media);
    Media update(Media media);
    void delete(Media media);


}

package com.ecommerce.repository;

import com.ecommerce.model.Media;

/**
 * Class {@link MediaDao}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 16.10.15
 */

public interface MediaDao {

    Media save(Media media);
    Media update(Media media);
    void delete(Media media);


}

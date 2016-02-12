package com.ecommerce.service.impl;

import com.ecommerce.model.Media;
import com.ecommerce.repository.MediaDao;
import com.ecommerce.service.MediaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class {@link MediaServiceImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 06.12.16
 */

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

    private static final Logger LOG = Logger.getLogger(MediaServiceImpl.class);

    @Autowired
    private MediaDao mediaDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Media media) {
        if (media == null) {
            throw new IllegalArgumentException("Media must not be null");
        }
        mediaDao.save(media);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Media media) {
        mediaDao.update(media);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Media media) {
        mediaDao.delete(media);

    }
}

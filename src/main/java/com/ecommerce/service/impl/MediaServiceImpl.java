package com.ecommerce.service.impl;

import com.ecommerce.model.Media;
import com.ecommerce.repository.MediaRepository;
import com.ecommerce.service.MediaService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class {@link com.ecommerce.repository.impl.UserRepositoryImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 16.10.15
 */

@Service("mediaService")
public class MediaServiceImpl implements MediaService {

    private static final Logger LOG = Logger.getLogger(MediaServiceImpl.class);

    @Autowired
    private MediaRepository mediaRepository;


    @Override
    public Media save(Media media) {
        if (media == null) {
            throw new IllegalArgumentException("Media must not be null");
        }
        return mediaRepository.save(media);
    }

    @Override
    public Media update(Media media) {
        return mediaRepository.update(media);
    }

    @Override
    public void delete(Media media) {
        mediaRepository.delete(media);

    }
}

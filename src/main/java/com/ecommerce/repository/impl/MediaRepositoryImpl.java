package com.ecommerce.repository.impl;

import com.ecommerce.model.Media;
import com.ecommerce.repository.MediaRepository;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Class {@link com.ecommerce.repository.impl.UserRepositoryImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 16.10.15
 */
@Repository
@Transactional
public class MediaRepositoryImpl implements MediaRepository {

    private static final Logger LOG = Logger.getLogger(MediaRepositoryImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Media save(Media media) {
        entityManager.persist(media);
        return media;
    }

    @Override
    public Media update(Media media) {
        entityManager.merge(media);
        return media;
    }

    @Override
    public void delete(Media media) {
        Media removingMedia = entityManager.find(Media.class, media.getId());
        entityManager.remove(removingMedia);
    }
}

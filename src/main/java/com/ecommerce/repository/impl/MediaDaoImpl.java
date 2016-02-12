package com.ecommerce.repository.impl;

import com.ecommerce.model.Media;
import com.ecommerce.repository.MediaDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * Class {@link MediaDaoImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 05.02.16
 */
@Repository
@Transactional
public class MediaDaoImpl implements MediaDao {


    @PersistenceContext
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Media media) {
        entityManager.persist(media);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Media media) {
        entityManager.merge(media);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(Media media) {
        Media removingMedia = entityManager.find(Media.class, media.getId());
        entityManager.remove(removingMedia);
    }
}

package com.ecommerce.service.impl;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductDao;
import com.ecommerce.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Class {@link ProductServiceImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 07.02.16
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        productDao.save(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
//    @Transactional
    public void update(Product product) {
        productDao.update(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product findOneById(Long id) {
        return productDao.findOneById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product findOneByTitle(String title) {
        return productDao.findOneByTitle(title);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Product> findByCategory(Long categoryId) {
        return productDao.findByCategory(categoryId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isProductExist(Long id) {
        if (!entityManager.contains(findOneById(id))) {
            return productDao.isProductExist(id);
        }
        return true;
    }
}

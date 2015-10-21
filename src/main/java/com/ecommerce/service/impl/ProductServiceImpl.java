package com.ecommerce.service.impl;

import com.ecommerce.model.Product;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
/**
 * Class {@link com.ecommerce.service.impl.UserServiceImpl}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 14.10.15
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = Logger.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product must not be null");
        }
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product findOneById(Long id) {
        return productRepository.findOneById(id);
    }

    @Override
    public Product findOneByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }

    @Override
    public List<Product> findByCategory(Long categoryId) {
        return productRepository.findByCategory(categoryId);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public boolean isProductExist(Long id) {
        if (!entityManager.contains(findOneById(id))) {
            return productRepository.isProductExist(id);
        }
        return true;
    }
}

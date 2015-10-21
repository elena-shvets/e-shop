package com.ecommerce.repository;

import com.ecommerce.model.Product;

import java.util.List;

/**
 * Class {@link com.ecommerce.repository.ProductRepository}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 15.10.15
 */

public interface ProductRepository {

    Product save(Product product);
    Product update(Product product);
    List<Product> getAll();
    Product findOneById(Long id);
    Product findOneByTitle(String title);
    List<Product> findByCategory(Long categoryId);
    void delete(Product product);
    boolean isProductExist(Long id);
}

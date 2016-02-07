package com.ecommerce.repository;

import com.ecommerce.model.Product;

import java.util.List;

/**
 * Class {@link ProductDao}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 15.10.15
 */

public interface ProductDao {

    void save(Product product);
    void update(Product product);
    List<Product> getAll();
    Product findOneById(Long id);
    Product findOneByTitle(String title);
//    List<Product> findByCategory(Long categoryId);
    void deleteById(Long id);
    boolean isProductExist(Long id);
}

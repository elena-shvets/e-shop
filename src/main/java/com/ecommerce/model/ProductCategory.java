package com.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Class {@link com.ecommerce.model.User}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 08.10.15
 */
@Entity
@Table(name = "category")
public class ProductCategory implements Serializable {

    private Long id;
    private String title;
    private Set<Product> products;

    public ProductCategory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id", unique = true, nullable = false, updatable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @OneToMany(cascade = CascadeType.ALL,  mappedBy = "category", fetch = FetchType.LAZY, targetEntity = Product.class)
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

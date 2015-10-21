package com.ecommerce.model;

import javax.persistence.*;

/**
 * Class {@link com.ecommerce.model.User}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 08.10.15
 */
@Entity
@Table(name = "category")
public class ProductCategory {

    private Long id;
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

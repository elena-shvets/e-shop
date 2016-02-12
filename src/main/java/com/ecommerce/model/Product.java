package com.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Class {@link Product}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 15.10.15
 */
@Entity
@Table(name = "products")
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product {

    private Long id;
    private String title;
    private BigDecimal price;
    private String description;
    private ProductCategory category;
    private Media media;

    public Product() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
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

    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne
    @JoinColumn(name = "category_id")
    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        result = (int) (PRIME * result + getId());
        return result;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Product p = (Product) o;
        return (this.getId() == p.getId());
    }

    @Override
    public String toString() {
        return "Product{" +
                "title=" + title +
                ", price=" + price +
                ", description=" + description +
                ", category=" + category.getTitle() +
                '}';
    }
}

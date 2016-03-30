package com.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by OSShvets on 30.03.2016.
 */
@Entity
@Table(name="order_item")
public class OrderItem {

    private Long id;
    private Long id_order;
    private Long id_product;
    private int count;
    private BigDecimal price;

    public OrderItem() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_order() {
        return id_order;
    }

    public void setId_order(Long id_order) {
        this.id_order = id_order;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal calculateTotalCost() {
        BigDecimal totalCost = this.getPrice().multiply(new BigDecimal(this.getCount()));
        return totalCost;
    }
}

package com.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by OSShvets on 30.03.2016.
 */

@Entity
@Table(name="order")
public class Order {

    private Long id;
    private String phone;
    private Date date_order;
//    private Product product;
    private OrderStatus status;
    private List<OrderItem> items;
    private BigDecimal totalCost;
    private int totalAmount;

    public Order() {

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDate_order() {
        return date_order;
    }

    public void setDate_order(Date date_order) {
        this.date_order = date_order;
    }

    @Enumerated(EnumType.STRING)
    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}

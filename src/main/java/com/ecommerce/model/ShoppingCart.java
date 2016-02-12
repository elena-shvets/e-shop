package com.ecommerce.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Class {@link ShoppingCart}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 07.02.2016
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ShoppingCart implements Serializable {

    private BigDecimal totalCost = BigDecimal.valueOf(0);
    private int totalAmount = 0;
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        items = new CopyOnWriteArrayList<ShoppingCartItem>();
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingCartItem> items) {
        this.items = items;
        recalcCostAndAmount();
    }

    public void addItem(ShoppingCartItem item) {
        boolean isExists = false;
        for (ShoppingCartItem it : items) {
            if (it.getProduct().equals(item.getProduct())) {
                it.setQuantity(it.getQuantity() + item.getQuantity());
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            items.add(item);
        }

        recalcCostAndAmount();
    }

    public void removeItem(ShoppingCartItem item) {
        items.remove(item);
        recalcCostAndAmount();
    }

    public void recalcCostAndAmount() {
        totalCost = BigDecimal.valueOf(0);
        totalAmount = 0;

        for (ShoppingCartItem item : items) {
            totalCost = totalCost.add(item.calculateTotalCost());
            totalCost.setScale(2, BigDecimal.ROUND_CEILING);
            totalAmount += item.getQuantity();
        }
    }

}

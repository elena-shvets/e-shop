package com.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Class {@link ShoppingCartItem}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 07.02.2016
 */

@Component
@Scope("session")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCartItem implements Serializable {

    private Product product;
    private Integer quantity;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Method that calculates the total cost of the order
     *
     * @return total cost
     */
    public BigDecimal calculateTotalCost() {
        BigDecimal totalCost = this.getProduct().getPrice().multiply(new BigDecimal(this.getQuantity()));
        return totalCost;
    }
}

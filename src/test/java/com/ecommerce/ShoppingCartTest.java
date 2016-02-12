package com.ecommerce;

import com.ecommerce.model.*;
import com.ecommerce.repository.ProductDao;
import com.ecommerce.service.ProductService;
import com.ecommerce.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Class {@link ShoppingCartTest}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 11.02.2016
 */

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartTest {

    @Mock
    private ProductDao dao;

    @InjectMocks
    private ProductService service = new ProductServiceImpl();

    @Test
    public void addToCart() {
        ProductCategory category = new ProductCategory();
        category.setId(1L);
        category.setTitle("Small household appliances");
        category.setProducts(new TreeSet<Product>());

        Product p1 = new Product();
        p1.setId(1L);
        p1.setTitle("LG");
        p1.setDescription("Best phone");
        p1.setPrice(BigDecimal.valueOf(1200));
        p1.setCategory(new ProductCategory());
        p1.setMedia(new Media());

        Product p2 = new Product();
        p2.setId(2L);
        p2.setTitle("Rowenta");
        p2.setDescription("hair dryer");
        p2.setPrice(BigDecimal.valueOf(620));
        p2.setCategory(new ProductCategory());
        p2.setMedia(new Media());

        Product p3 = new Product();
        p3.setId(3L);
        p3.setTitle("Philips");
        p3.setDescription("TV");
        p3.setPrice(BigDecimal.valueOf(9450));
        p3.setCategory(new ProductCategory());
        p3.setMedia(new Media());

        ShoppingCartItem item1 = new ShoppingCartItem();
        item1.setProduct(p1);
        item1.setQuantity(1);

        ShoppingCartItem item2 = new ShoppingCartItem();
        item2.setProduct(p2);
        item2.setQuantity(2);

        ShoppingCartItem item3 = new ShoppingCartItem();
        item3.setProduct(p3);
        item3.setQuantity(1);

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item1);
        cart.addItem(item2);
        cart.addItem(item3);

        assertTrue(cart.getItems().size() == 3);
        assertTrue(cart.getTotalAmount() == 4);
        assertEquals(cart.getTotalCost(), BigDecimal.valueOf(11890));
    }

    @Test
    public void removeFromCart() {
        ProductCategory category = new ProductCategory();
        category.setId(1L);
        category.setTitle("Small household appliances");
        category.setProducts(new TreeSet<Product>());

        Product p1 = new Product();
        p1.setId(4L);
        p1.setTitle("Samsung");
        p1.setDescription("The Best");
        p1.setPrice(BigDecimal.valueOf(3300));
        p1.setCategory(new ProductCategory());
        p1.setMedia(new Media());

        Product p2 = new Product();
        p2.setId(5L);
        p2.setTitle("Scarlet");
        p2.setDescription("hair dryer");
        p2.setPrice(BigDecimal.valueOf(410));
        p2.setCategory(new ProductCategory());
        p2.setMedia(new Media());

        Product p3 = new Product();
        p3.setId(6L);
        p3.setTitle("LG");
        p3.setDescription("TV");
        p3.setPrice(BigDecimal.valueOf(6800));
        p3.setCategory(new ProductCategory());
        p3.setMedia(new Media());

        ShoppingCartItem item1 = new ShoppingCartItem();
        item1.setProduct(p1);
        item1.setQuantity(2);

        ShoppingCartItem item2 = new ShoppingCartItem();
        item2.setProduct(p2);
        item2.setQuantity(3);

        ShoppingCartItem item3 = new ShoppingCartItem();
        item3.setProduct(p3);
        item3.setQuantity(1);

        List<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
        items.add(item1);
        items.add(item2);
        items.add(item3);

        ShoppingCart cart = new ShoppingCart();
        cart.setItems(items);

        ShoppingCartItem next = items.iterator().next();
        when(service.findOneById(6L)).thenReturn(p3);
        cart.removeItem(item3);
    }

}

package com.ecommerce.controllers;

import com.ecommerce.model.Product;
import com.ecommerce.model.ShoppingCart;
import com.ecommerce.model.ShoppingCartItem;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Iterator;
import java.util.List;

/**
 * Class {@link ShoppingCartController}
 *
 * @author Elena Shvets
 * @version 1.0
 * @since 08.02.16
 */
@Controller
@Scope(value = "session")
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private HttpSession session;


    /**
     * Method that adds an item to cart and calculate the total cost of the order
     *
     * @param productId
     * @param model
     * @param request
     * @return shoppingCart's info
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<ShoppingCart> addToCart(@PathVariable Long productId, Model model, HttpServletRequest request) {

        Product prodToCart = productService.findOneById(productId);
        ShoppingCartItem cartItem = new ShoppingCartItem();
        cartItem.setProduct(prodToCart);
        cartItem.setQuantity(1);

        ShoppingCart cart;
        session = request.getSession(true);

        cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null) {
            cart.addItem(cartItem);
            session.setAttribute("cart", cart);
//            cart = (ShoppingCart) session.getAttribute("cart");
        } else {
            cart = new ShoppingCart();
            cart.addItem(cartItem);
            session.setAttribute("cart", cart);

        }
        model.addAttribute("quantity", cart.getTotalAmount());
        model.addAttribute("cost", cart.getTotalCost());

        return new ResponseEntity(model, HttpStatus.OK);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<ShoppingCart> info(Model model, HttpServletRequest request) {

        ShoppingCart cart;
        session = request.getSession(true);

        cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
        }

        model.addAttribute("quantity", cart.getTotalAmount());
        model.addAttribute("cost", cart.getTotalCost());

        return new ResponseEntity(model, HttpStatus.OK);
    }

    /**
     * Method that shows products list and shopping cart
     * @param model
     * @param request
     * @return show shopping cart
     */
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(Model model, HttpServletRequest request) {

        ShoppingCart cart;
        session = request.getSession(true);

        cart = (ShoppingCart) session.getAttribute("cart");
        if (cart == null) {
            cart = new ShoppingCart();
        }

        model.addAttribute("items", cart.getItems());

        return "view.cart";
    }

    /**
     * Method that removes an item from cart and calculate the total cost of the order
     * @param productId
     * @param request
     * @return result - http redirect
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.POST)
    public ModelAndView removeFromCart(@PathVariable Long productId, HttpServletRequest request) {
        Product prodFromCart = productService.findOneById(productId);

        ShoppingCart cart;
        session = request.getSession(true);

        cart = (ShoppingCart) session.getAttribute("cart");
        if (cart != null) {

            List<ShoppingCartItem> cartItems = cart.getItems();

            Iterator<ShoppingCartItem> iter = cartItems.iterator();
            while (iter.hasNext()) {
                ShoppingCartItem next = iter.next();
                if (next.getProduct().getId() == prodFromCart.getId()) {
                    cart.removeItem(next);
                }
            }
        }

        session.setAttribute("cart", cart);

        return new ModelAndView("redirect:checkout");
    }
}

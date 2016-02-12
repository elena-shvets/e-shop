<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<script src="/resources/js/shopping_cart.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/all_products.css">
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<section class="content">
    <div id="goods">
        <div id="left">
            <div id="center">
                <c:forEach var="product" items="${products}">
                    <table border="0">
                        <tr>
                            <td rowspan="4"><img src="/resources/image/tehnika.resized.jpg"></td>
                            <td>${product.title}</td>
                        </tr>
                        <tr>
                            <td>Price: ${product.price}</td>
                        </tr>
                        <tr>
                            <td>${product.description}</td>
                        </tr>
                        <tr>
                            <td>
                                <input id="cart_btn" class="btn add2card" type="button" value="Add to cart"
                                       data-product-id="${product.id}"/>
                                <a href='${product.id}'>
                                    <input type="button" class="btn" value="View" data-product-id="${product.id}">
                                </a>
                            </td>
                        </tr>
                    </table>
                </c:forEach>
            </div>
        </div>
    </div>
    <div id="right">
        <div class="rbox"><span></span>Shopping cart</div>
        <div class="cartItem">
            <ul id="items">

                <li>Quantity: <span id="cartQuantity">${quantity}</span></li>
                <li>Total cost: <span id="cartCost">${cost}</span></li>

            </ul>
        </div>
    </div>
    </div>
</section>

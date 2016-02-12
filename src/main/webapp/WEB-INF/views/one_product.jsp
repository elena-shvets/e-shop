<%--
  Created by IntelliJ IDEA.
  User: elena
  Date: 01.12.15
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/one_product.css">
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<script src="/resources/js/shopping_cart.js"></script>

<section class="content">
    <div id="goods">
        <div id="left">
            <div id="center">
                <div id="left_part">
                    <div class="content_veiw" id="title">${title}</div>
                    <div><img src="/resources/image/tehnika.resized.jpg"></div>

                </div>
                <div id="right_part">

                    <div class="title_name">Price:</div>
                    <div class="content_veiw" id="price">${price}</div>
                    <div class="title_name">Description:</div>
                    <div class="content_veiw">${description}</div>
                    <div id="cart">
                        <input id="cart_btn" class="btn add2card" type="button" value="Add to cart"
                               data-product-id="${prodId}">
                    </div>
                </div>
            </div>
        </div>
        <div id="right">
            <div class="rbox"><span></span>Shopping cart</div>
            <div class="cartItem">
                <ul id="items">

                    <li>Quantity: <span id="cartQuantity">0</span></li>
                    <li>Total cost: <span id="cartCost">0</span></li>

                </ul>
            </div>
        </div>
    </div>
</section>


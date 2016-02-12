<%--
  Created by IntelliJ IDEA.
  User: elena
  Date: 01.12.15
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<script src="/resources/js/shopping_cart.js"></script>
<section class="content">
    <form action="/cart/update" method="POST">
        <c:forEach var="item" items="${items}">
            <div>
                <table>
                    <tr>
                        <td width="150">${item.product.title}</td>
                        <td>
                            <input type="input" size="3" name="quantity[${item.product.id}]" value="${item.quantity}"/>
                            <input class="btn removeFromCart" type="button" value="Delete"
                                   data-product-id="${item.product.id}">
                        </td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </c:forEach>
        <!--<input type="submit" class="btn" value="save" />-->
    </form>
    <div>
        <ul id="items">

            <li>Quantity: <span id="cartQuantity">0</span></li>
            <li>Total cost: <span id="cartCost">0</span></li>

        </ul>
    </div>
</section>


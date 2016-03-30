<%--
  Created by IntelliJ IDEA.
  User: elena
  Date: 18.03.16
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<form name="search-form" class="header-search1" method="POST" action="/products/${product.id_prod}">
    <div>
        <input autocomplete="off" type="text" class="header-search-input-text1" name="search" placeholder="Поиск"
               value="" tabindex="1" data-product-id="${product.id_prod}">
    </div>
    <a href='/product/find/${product.id_prod}'>
                    <span class="btn-link-green1" >
                        <button class="btn-link-i1" type="submit">Найти</button>
                    </span>
    </a>
</form>
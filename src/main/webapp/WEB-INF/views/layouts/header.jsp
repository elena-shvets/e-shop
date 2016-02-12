<%--
  Created by IntelliJ IDEA.
  User: Elena Shvets
  Date: 04.02.16
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header:start -->

<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/css/header.css">

<div id="main">
    <div id="header">

        <div id="hdr-box1" class="box"></div>
        <div id="hdr-box2" class="box"></div>
        <div id="hdr-box3" class="box"></div>
        <div id="hdr-box4" class="box"></div>

        <h1>ecommerce</h1>

        <h2>You can find here everything you want</h2>

    </div>
    <ul id="menu">
        <li><a href="/hello/greeting"><span></span>Home</a></li>
        <li><a href="/products/getAll"><span></span>All products</a></li>
        <li><a href="/products/create"><span></span>Admin</a></li>
        <li><a href="/cart/checkout"><span></span>Shopping cart</a></li>
        <li><a href="/user/login"><span></span>Sign in</a></li>
    </ul>

</div>

<!-- header:end -->
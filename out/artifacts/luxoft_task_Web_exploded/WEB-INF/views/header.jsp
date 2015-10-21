<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<!-- header:start -->
<div class="navbar">
    <div class="navbar-inner">
        <div class="logo pull-left">
            <a class="brand" href="#">&nbsp;</a>
        </div>
        <div class="container">
            <div class="collapse">

            </div>
            <div class="nav-wrapper-bottom">
                <ul class="products-top-menu">
                    <li class="active" id="all_products"><a href="/products/getAll">All products</a></li>
                    <li id="popular"><a href="/products/{productId}">Popular</a></li>
                </ul>

            </div>
        </div>
    </div>
</div>
<!-- header:end -->
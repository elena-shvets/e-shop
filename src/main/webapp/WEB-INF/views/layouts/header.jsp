<%--
  Created by IntelliJ IDEA.
  User: Elena Shvets
  Date: 04.02.16
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- header:start -->
<html>
<head>
<%--<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-min.js"/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/resources/js/lib/jquery-ui.min.js"/>"></script>--%>
<style>
/*#border{*/
/*width: 100%;*/
/*height: 100px;*/
/*margin: 0;*/
/*padding: 0;*/
/*border: none;*/
/*overflow: auto;*/

/*}*/
#main {
    position: relative;
    width: 100%;
    height: 160px;
    margin: 0 auto;
    padding: 13px 0 0 0;
}

body {
    background: white;
    color: #009999;
}

body {
    margin: 0;
    padding: 0;
    background: #e0e0e0;
    color: #333;
    font: 12px/1.5 'segoe ui', 'lucida sans unicode', 'lucida grande', lucida, sans-serif;
}


#header {
    background: #009999;
}

#header {
    position: absolute;
    width: 100%;
    height: 130px;
    margin: -2px;

}

div {
    display: block;
}

#header .box {
    position: absolute;
    top: 6px;
    width: 75px;
    height: 25px;
    background: silver;
}

#header #hdr-box1 {
    background: #46b3b3;
}

#hdr-box1 {
    left: 15px;
}

#header #hdr-box2 {
    background: #24a0a0;
}

#hdr-box2 {
    left: 100px;
}

#header #hdr-box3 {
    background: #007777;
}

#hdr-box3 {
    left: 185px;
}

#header #hdr-box4 {
    background: #005d5d;
}

#hdr-box4 {
    left: 270px;
}

/*#header h1 {*/
/*display: none;*/
/*}*/
h1 {
    display: block;
    font-size: 4em;
    -webkit-margin-before: 0.75em;
    -webkit-margin-after: 0.67em;
    -webkit-margin-start: 50px;
    -webkit-margin-end: 50px;
    font-weight: bold;
}

h2 {
    display: block;
    -webkit-margin-before: 0.83em;
    -webkit-margin-after: 0.83em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
}

#header h1 {
    color: #46b3b3;
    font-style: italic;
}

#header h2 {
    color: #005d5d;
}

#header h2 {
    position: absolute;
    top: 60px;
    right: 120px;
    margin: 0;
    width: 14em;
    font-size: 15px;
    line-height: 1.33;
    font-weight: bold;
    text-transform: uppercase;
    text-align: right;
}

#menu {
    border-color: #0d3184;
}

#menu {
    margin: 0;
    padding: 130px 0 0 0;
    list-style-type: none;
    height: 30px;

}

#menu a {
    background: #5777c0;
    color: #082568;
}

#menu a.sel {
    background: #0d3184;
    color: #5777c0;
}

#menu a.sel {
    background: silver;
    color: black;
}

#menu li {
    float: left;
    margin: 0;
    padding: 0;
    width: 20%;
}

li {
    display: list-item;
    text-align: -webkit-match-parent;
}

#menu a span {
    background: #1240ab;
}

#menu a span {
    display: block;
    position: absolute;
    top: 5px;
    left: 8px;
    width: 8px;
    height: 8px;
}

ul, menu, dir {
    display: block;
    list-style-type: disc;
    -webkit-margin-before: 1em;
    -webkit-margin-after: 1em;
    -webkit-margin-start: 0px;
    -webkit-margin-end: 0px;
    -webkit-padding-start: 40px;
}

#menu a {
    position: relative;
    display: block;
    margin: 1px;
    height: 24px;
    font-size: 12px;
    line-height: 24px;
    text-decoration: none;
    text-transform: uppercase;
    text-align: center;
    background: #5777c0;
    color: white;
}

a:-webkit-any-link {
    color: -webkit-link;
    text-decoration: underline;
    cursor: auto;
}

</style>
<%--<script type="text/css" src="<c:url value="/resources/css/style.css"/>"></script>--%>
</head>
<body marginheight="0" marginwidth="0">

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
        <li><a href=""><span></span>Payments</a></li>
        <li><a href="/user/login"><span></span>Sign up</a></li>
    </ul>

</div>

</body>
</html>
<!-- header:end -->
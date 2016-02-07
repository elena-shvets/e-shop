<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <link href="/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="/css/slider.css" rel="stylesheet">
    <link href="/webapp/css/style.css" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="/css/jquery.jscrollpane.css">
    <link type="text/css" rel="stylesheet" href="/css/smoothness/jquery-ui-1.10.4.custom.min.css">
    <link rel="stylesheet" type="text/css" href="/css/easydropdown.css">
    <script type="text/javascript" src="/js/jquery.js"></script>
    <script type="text/javascript" src="/js/jquery.mousewheel.js"></script>
    <script type="text/javascript" src="/js/jquery.jscrollpane.min.js"></script>
    <script type="text/javascript" src="/js/jquery.formatDateTime.min.js"></script>
    <script type="text/javascript" src="/js/jquery-ui-1.10.4.custom.min.js"></script>
    <script type="text/javascript" src="/js/jquery.easydropdown.min.js"></script>
    <%--<script type="text/javascript" src="/js/dust-full.min.js"></script>--%>
    <%--<script type="text/javascript" src="/js/dust-helpers-1.1.2.js"></script>--%>

    <script type="text/javascript" src="/js/global.js"></script>


    <script type="text/javascript" src="/js/mobilyslider.js"></script>

    <script type="text/javascript" src="/js/client.js"></script>


    <title>Main Page</title>
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>

<body>
<div class="bg_main_page"><img src="/img/fon_bg_start.jpg" alt=""></div>
<div class="main">
    <tiles:insertAttribute name="header"/>

    <tiles:insertAttribute name="body"/>

</div>
<tiles:insertAttribute name="footer"/>

</body>

</html>
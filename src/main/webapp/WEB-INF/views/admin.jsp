<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena Shvets
  Date: 04.02.16
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%--<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">--%>

<head>
    <%--<sec:authorize />--%>
    <%--<meta name="_csrf_parameter" content="_csrf" />--%>
    <%--<meta name="_csrf_header" content="X-CSRF-TOKEN" />--%>
    <%--<meta name="_csrf" content="e62835df-f1a0-49ea-bce7-bf96f998119c" />--%>
    <title></title>
    <style>
        .content {
            background-color: floralwhite;
            height: 500px;
            width: 100%;
            padding: 1px;
        }

        .form {
            margin: 0 auto;
            width: 50%;
            font-size: 15px;
            color: #9b6800;
            border-color: #9b6800;
        }

        .style {
            font-size: 15px;
            color: #9b6800;
        }
        .adm{
            margin: 0 auto;
            float: left;
            width: 40%;
            height: 200px;
            padding: 20px 20px;
            border-color: #005d5d;
        }
        .form_view{
            padding-top: 100px;
            border: 1px;
            border-color: #9b6800;
        }
        .btn {
            background: #ffcb64;
            width: 75px;
            height: 25px;
            margin: 15px 0 5px 0;
            padding: 5px 5px 2px 5px;
            font-size: 12px;
            text-transform: uppercase;
            text-align: center;
            color: #9b6800;
            line-height: 1.2;
            padding-right: 15px;
            padding-left: 15px;
            padding-top: 5px;
            left: 1100px;
        }
    </style>
</head>
<body>
<section class="content">
  <div class="form_view">
    <%--<form id="prod_form" action="/products/create?${_csrf.parameterName}=${_csrf.token}" method="POST" enctype="multipart/form-data">--%>
    <form id="prod_form" action="/products/created" method="GET" enctype="multipart/form-data">
        <table>
            <div class="adm">
                <tr>
                    <div class="form">New product:</div>

                </tr>
                <tr>
                    <div class="form">
                        <td class="style">Title:</td>
                        <td><input type="text" value=""></td>
                    </div>
                </tr>
                <tr>
                    <div class="form">
                        <td class="style">Price:</td>
                        <td><input type="text" value=""></td>
                    </div>
                </tr>
                <tr>
                    <div class="form">
                        <td class="style"> Description:</td>
                        <td><input type="text" value=""></td>
                    </div>
                </tr>
                <%--<tr>--%>
                    <%--<div class="form">--%>
                        <%--<td class="style"> Category:</td>--%>
                        <%--<td><input type="text" value=""></td>--%>
                    <%--</div>--%>
                <%--</tr>--%>
                <tr>
                    <div class="form">
                        <td><input class="btn" type="submit" value="Save"></td>
                    </div>
                </tr>

            </div>
        </table>
        <%--<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>
    </form>
  </div>
</section>
</body>
</html>

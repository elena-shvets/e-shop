<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Elena Shvets
  Date: 04.02.16
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<link rel="stylesheet" type="text/css" href="/resources/css/admin.css">--%>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<section class="content">
    <div class="form_view">

        <form id="prod_form" action="/products/create" method="POST">
            <table>
                <div class="adm">
                    <tr>
                        <div class="form">New product:</div>

                    </tr>
                    <tr>
                        <div class="form">
                            <td class="style">Title:</td>
                            <td><input type="text" name="title" value="" path="title"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form">
                            <td class="style">Price:</td>
                            <td><input type="text" value="" path="price"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form">
                            <td class="style"> Description:</td>
                            <td><input type="text" name="description" value="" path="description"></td>
                        </div>
                    </tr>
                    <%--<tr>--%>
                    <%--<div class="form">--%>
                    <%--<td class="style"> Category:</td>--%>
                    <%--<td><input type="text" value="" path="category"></td>--%>
                    <%--</div>--%>
                    <%--</tr>--%>
                    <tr>
                        <div class="form">
                            <td><input class="btn" type="submit" value="Save"></td>
                        </div>
                    </tr>

                </div>
            </table>

        </form>
    </div>
</section>


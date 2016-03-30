<%--
  Created by IntelliJ IDEA.
  User: Elena Shvets
  Date: 04.02.16
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<link rel="stylesheet" type="text/css" href="/resources/css/login.css">--%>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">

<section class="content">
    <div class="form_view">
        <form id="login_form" action="/user/login" method="POST">
            <table>
                <div id="log">
                    <tr>
                        <div class="form">
                            <td class="style">Email:</td>
                            <td><input id="email" name="email" type="text" path="email"></td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form">
                            <td class="style">Password:</td>
                            <td><input id="pass" name="password" type="password" path="password">
                                <div>Password must have at least 1<br>
                                    number and be between 6 and 30 characters long</div>
                            </td>
                        </div>
                    </tr>
                    <tr>
                        <div class="form">
                            <td><input class="btn" type="submit" value="Login"></td>
                        </div>
                    </tr>
                </div>

            </table>
        </form>
    </div>
</section>



<%--
  Created by IntelliJ IDEA.
  User: Elena Shvets
  Date: 04.02.16
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>
        .content {
            background-color: floralwhite;
            height: 500px;
            width: 100%;
            padding: 1px;
        }

        #log {

            margin: 0 auto;

            float: left;
            width: 40%;
            height: 200px;
            padding: 20px 20px;
            border-color: #005d5d;
        }
        .style {
            font-size: 15px;
            color: #9b6800;
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

        .form {
            margin: 0 auto;
            width: 50%;
            font-size: 15px;
            color: #9b6800;
            border-color: #9b6800;
        }
    </style>
</head>
<body>
<section class="content">
<div class="form_view">
    <form id="login_form" action="/login" method="post">
        <table>
        <div id="log">
            <tr>
            <div class="form">
               <td class="style">Email:</td>
                <td><input id="login" type="text"></td>
            </div>
            </tr>
            <tr>
            <div class="form">
                <td class="style">Password:</td>
                <td><input id="password" type="password"></td>
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
</body>
</html>

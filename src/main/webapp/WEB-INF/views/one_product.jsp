<%--
  Created by IntelliJ IDEA.
  User: elena
  Date: 01.12.15
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

        #goods {
            width: 100%;
        }

        #left {
            margin: 0 auto;
            float: left;
            width: 77%;
            height: 482px;
            padding: 10px 20px;
            border-right: 1px dotted white;
            border-color: #005d5d;
        }

        #right_part {

            display: inline;
        }

        #left_part {
            float: left;
            width: 25%;
            display: inline;
        }

        #center {
            margin: 0 auto;
            width: 50%;
        }

        #right {
            float: right;
            width:23%;
            margin: 0 20px 0 0;
            padding: 10px 0;
        }

        #rbox span {
            background-color: #9b6800;
            display: block;
            position: absolute;
            top: 13px;
            left: 8px;
            width: 8px;
            height: 8px;
        }

        #rbox {
            float: left;
            background: #ffcb64;
            position: absolute;
            top: 200px;
            width: 75px;
            height: 25px;
            margin: 15px 0 5px 0;
            padding: 5px 5px 2px 5px;
            font-size: 12px;
            text-transform: uppercase;
            text-align: center;
            color: #9b6800;;
            line-height: 1.2;
            padding-right: 15px;
            padding-left: 20px;
            padding-top: 10px;
            left: 1100px;
        }

        .content_veiw {
            font-size: 15px;
            color: #9b6800;
        }

        #title {
            font-size: 20px;
            color: #9b6800;
        }

        .title_name {
            font-size: 20px;
            color: #9b6800;
        }


    </style>
</head>
<body>
<section class="content">
    <div id="goods">
        <div id="left">
            <div id="center">
                <div id="left_part">
                    <div class="content_veiw" id="title">${title}</div>
                    <div><img src="/resources/image/tehnika.resized.jpg"></div>

                </div>
                <div id="right_part">

                    <div class="title_name">Price:</div>
                    <div class="content_veiw" id="price">${price}</div>
                    <div class="title_name">Description:</div>
                    <div class="content_veiw">${description}</div>

                </div>

            </div>
        </div>
        <div id="right">
            <div id="rbox"><span></span>Bucket</div>
            <ul></ul>
        </div>
    </div>
</section>
</body>
</html>

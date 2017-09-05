<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page  language="java" pageEncoding="utf-8" %>
<%String path = request.getContextPath();%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Login Page | Amaze UI Example</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="alternate icon" type="image/png" href="<%=path%>static/plugins/assets/i/favicon.png">
    <link rel="stylesheet" href="<%=path%>static/plugins/assets/css/amazeui.min.css"/>
    <script src="<%=path%>static/plugins/jquery-2.1.4/jquery.min.js"></script>

    <style>
        .header {
            text-align: center;
        }
        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }
        .header p {
            font-size: 14px;
        }
    </style>
</head>
<body>

<div class="header">
    <div class="am-g">
        <h1>Web ide</h1>
    </div>
    <hr />
</div>
<div class="am-g">
    <div class="am-u-lg-6 am-u-md-8 am-u-sm-centered">
        <h3>登录</h3>
        <hr>


        <form action="/login.do" method="post" class="am-form">
            <span style="color: #FF0000;">${msg}</span>
            <br>
            <label for="username">账号:</label>
            <input type="text" name="username" id="username" value="">
            <br>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password" value="">
            <br>
            <label for="remember-me">
                <input id="remember-me" type="checkbox">
                记住密码
            </label>
            <br />
            <div class="am-cf">
                <input type="submit"  value="登 录"  class="am-btn am-btn-primary am-btn-sm am-fl">
                <!-- <input type="submit" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">-->
            </div>
        </form>
        <hr>
        <p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </div>
</div>
</body>
</html>

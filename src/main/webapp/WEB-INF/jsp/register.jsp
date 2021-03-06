<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/6
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
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
    <link rel="alternate icon" type="image/png" href="<%=path%>/static/plugins/assets/i/favicon.png">
    <link rel="stylesheet" href="<%=path%>/static/plugins/assets/css/amazeui.min.css"/>
    <script src="<%=path%>/static/plugins/jquery-2.1.4/jquery.min.js"></script>

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
        <h3>注册</h3>
        <hr>
        <form action="<%=path%>/register" method="post" class="am-form" onsubmit="return checkRegisterForm()">
            <span style="color: #FF0000;">${msg}</span>
            <br>
            <label for="username">账号:</label>
            <input type="text" name="username" id="username" >
            <br>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password" >
            <br>
            <label for="repassword">确认密码:</label>
            <input type="text" name="repassword" id="repassword" >
            <br>
            <br />
            <div class="am-cf">
                <input type="submit"  id="submit" value="注 册"  class="am-btn am-btn-primary am-btn-sm am-fl">
            </div>
        </form>
        <hr>
        <p>© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
    </div>
</div>
</body>


<script>
    function checkRegisterForm() {
        var username = $('#username').val();
        var password = $('#password').val();
        var repassword = $('#repassword').val();
        if(isNull(username) && isNull(password)){
            $('#submit').attr('value','请输入账号和密码!!!').css('background','red');
            return false;
        }
        if(isNull(username)){
            $('#submit').attr('value','请输入账号!!!').css('background','red');
            return false;
        }
        if(isNull(password)){
            $('#submit').attr('value','请输入密码!!!').css('background','red');
            return false;
        }
        if (isNull(repassword)) {
            $('#submit').attr('value','请确认输入密码!!!').css('background','red');
            return false;
        }
        if (repassword != password) {
            $('#submit').attr('value','两次密码不相同!!!').css('background','red');
            return false;
        }
        else {
            return true;
        }
    }

    function isNull(input) {
        if (input == null || input =='' || (typeof(input) == "undefined")) {
            return true;
        } else {
            return false;
        }
    }
</script>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%String path = request.getContextPath();%>

<html>
<head>
    <title>Amaze UI Admin index Examples</title>
    <link rel="stylesheet" href="<%=path%>static/plugins/assets/css/amazeui.min.css"/>
    <script src="<%=path%>static/plugins/jquery-2.1.4/jquery.min.js"></script>
</head>
<body>

<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <i class="am-icon-weixin"></i> <strong>WebChat</strong> <small>网页聊天室</small>
    </div>
</header>

<div class="am-cf admin-main">
    <!-- 聊天区 -->
    <div class="am-scrollable-vertical" id="chat-view" style="height: 510px;">
        <ul class="am-comments-list am-comments-list-flip" id="chat">
        </ul>
    </div>
    <!-- 输入区 -->
    <div class="am-form-group am-form">
        <textarea class="" id="message" name="message" rows="5"  placeholder="这里输入你想发送的信息..."></textarea>
    </div>
    <!-- 接收者 -->
    <div class="" style="float: left">
        <p class="am-kai">发送给 : <span id="sendto">全体成员</span><button class="am-btn am-btn-xs am-btn-danger" onclick="$('#sendto').text('全体成员')">复位</button></p>
    </div>
    <!-- 按钮区 -->
    <div class="am-btn-group am-btn-group-xs" style="float:right;">
        <button class="am-btn am-btn-default" type="button" onclick="getConnection()"><span class="am-icon-plug"></span> 连接</button>
        <button class="am-btn am-btn-default" type="button" onclick="closeConnection()"><span class="am-icon-remove"></span> 断开</button>
        <button class="am-btn am-btn-default" type="button" onclick="checkConnection()"><span class="am-icon-bug"></span> 检查</button>
        <button class="am-btn am-btn-default" type="button" onclick="clearConsole()"><span class="am-icon-trash-o"></span> 清屏</button>
        <button class="am-btn am-btn-default" type="button" onclick="sendMessage()"><span class="am-icon-commenting"></span> 发送</button>
    </div>

    <!-- content start -->

</div>

<footer class="admin-content-footer">
    <hr>
    <p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
</footer>
</div>
<!-- content end -->

</div>
</body>

<script type="text/javascript">
    var websocket = null;
    var ws = null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        ws = "ws://" + location.host+ "/websocket"
        websocket = new WebSocket(ws);
    }
    else {
        alert('当前浏览器 Not support websocket');
    }
    //连接发生错误的回调方法
    websocket.onerror = function () {
        setMessageInnerHTML("WebSocket连接发生错误");
    };
    //连接成功建立的回调方法
    websocket.onopen = function () {
        setMessageInnerHTML("WebSocket连接成功");
    }
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
        setMessageInnerHTML(event.data);
    }
    //连接关闭的回调方法
    websocket.onclose = function () {
        setMessageInnerHTML("WebSocket连接关闭");
    }
    //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }
    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        document.getElementById('chat-view').innerHTML += innerHTML + '<br/>';
        var chat = $('#chat-view');
        chat.scrollTop(chat[0].scrollHeight);   //让聊天区始终滚动到最下面
    }
    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }
    //发送消息
    function sendMessage() {
        var message = document.getElementById('message').value;
        message =  "${username}说：" + message  ;
        websocket.send(message);
        $('#message').val("");  //清空输入区
    }
</script>

</html>

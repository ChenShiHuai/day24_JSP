<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>500页面</title>
</head>
<body>
服务器正忙。。。。。，请稍后
<%
    String message = exception.getMessage();
    out.println(message);
%>
</body>
</html>

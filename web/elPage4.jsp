<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式获取动态虚拟目录</title>
</head>
<body>
<h3>el表达式获取动态虚拟目录</h3>
<%--类似request.getContextPath();--%>
访问路径：${pageContext.request.contextPath}
</body>
</html>

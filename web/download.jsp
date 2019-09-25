<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 下午 4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>下载页面</title>
</head>
<body>


<a href="${pageContext.request.contextPath}/img/1.jpg">下载图片1</a>

<hr>

<a href="${pageContext.request.contextPath}/downloadServlet?filename=1.jpg">下载图片1</a>
<a href="${pageContext.request.contextPath}/downloadServlet?filename=2.jpg">下载图片2</a>
<a href="${pageContext.request.contextPath}/downloadServlet?filename=九尾.jpg">下载中文文件名</a>

</body>
</html>

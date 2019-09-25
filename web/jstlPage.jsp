<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--2. 导入jstl相关jar包
3. 引入标签库：taglib指令：  <%@ taglib %>
4. 使用标签--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl标签页面</title>
</head>
<body>
<%

    List list = new ArrayList<>();
    list.add("addd");

    request.setAttribute("list",list);

    request.setAttribute("number",3);

%>


<c:if test="${empty list}">
    是空集合
</c:if>

<c:if test="${not empty list}">
    非空集合
</c:if>

<c:if test="${number%2==0}">
    是偶数
</c:if>

<c:if test="${number%2!=0}">
    是奇数
</c:if>


</body>
</html>

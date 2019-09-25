<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 1:04
  To change this template use File | Settings | File Templates.
--%>
<%--contentType：等同于response.setContentType()--%>
<%@ page contentType="text/html;charset=UTF-8"  language="java" errorPage="500.jsp" %>
<%--静态包含--%>
<%@include file="top.jsp"%>

<%--动态包含
<jsp:include page="500.jsp"></jsp:include>--%>
<html>
  <head>
    <title>这是jsp页面</title>

  </head>
  <body>
  <%

  List list = new ArrayList<>();

  int i=10/0;
  %>


<%--zheshiwode zhushi 这是jsp的注释--%>
  <!--这是html的注释。。。-->
  </body>
</html>

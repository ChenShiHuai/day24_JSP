<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>elPage</title>
</head>
<body>
\${3>4}

<h3>算术运算符</h3>
${3+4}<br/>
${3*4}<br/>
${3/4}<br/>
${3 div 4}<br/>
${3 mod 4}<br/>

<h3>逻辑运算符</h3>
${4>3 and 3>4}<br/>
${4>3 && 3>4}<br/>


<h3>空运算符</h3>

<%
    String str = "abc";
    request.setAttribute("str",str);

    List list = new ArrayList<>();
    request.setAttribute("list",list);
%>



${not empty str}<br/>
${not empty list}<br/>



</body>
</html>

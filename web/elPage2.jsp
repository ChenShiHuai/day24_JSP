<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取值</title>
</head>
<body>
<%

    request.setAttribute("name","wowo");

    session.setAttribute("msg","hello");

    session.setAttribute("name","uuuuu");

%>

<h3>el获取域对象的值</h3>
${requestScope.name}<br/>
${sessionScope.msg}

${msg}<br/>
倘若没有相应的key:${sessionScope.haha}<br/>

</body>
</html>

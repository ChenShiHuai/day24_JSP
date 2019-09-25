<%@ page import="java.util.ArrayList" %>
<%@ page import="com.qf.el.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 下午 2:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>练习</title>
</head>
<body>

<%

    List<User> list = new ArrayList<>();
    User user1 = new User(23,"wowo",new Date());
    User user2 = new User(24,"sdfsd",new Date());
    User user3 = new User(23,"ppp",new Date());
    list.add(user1);
    list.add(user2);
    list.add(user3);

    request.setAttribute("list",list);

%>


<c:if test="${not empty list}">

   <table border="1" cellspacing="0" width="500" align="center">
       <tr>
           <th>编号</th>
           <th>姓名</th>
           <th>年龄</th>
           <th>生日</th>
       </tr>
       <c:forEach items="${list}" var="user" varStatus="s">
           <tr>
               <td>${s.count}</td>
               <td>${user.name}</td>
               <td>${user.age}</td>
               <td>${user.birthStr}</td>
           </tr>

       </c:forEach>


   </table>


</c:if>


</body>
</html>

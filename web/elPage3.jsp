<%@ page import="com.qf.el.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/9/20 0020
  Time: 上午 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el语言获取自定义对象，List,Map</title>
</head>
<body>

<%
    User user = new User(23,"wowo",new Date());
    request.setAttribute("user",user);

    User user2 = new User(59,"喔喔",new Date());
    User user3 = new User(35,"匹配",new Date());

    List<User> userList = new ArrayList<>();
    userList.add(user);
    userList.add(user2);
    userList.add(user3);
    request.setAttribute("list",userList);


    Map sMap = new HashMap<>();
    sMap.put("name","wowo");
    sMap.put("user",user);

    request.setAttribute("sMap",sMap);


%>

<h3>自定义对象</h3>
姓名：${user.name}<br/>
年龄：${user.age}<br/>
生日：${user.birthday}<br/>
生日：${user.birthStr}<br/>

<h3>获取集合中值</h3>
${list[0].name}<br/>
${list[0].age}<br/>
${list[0].birthStr}<br/>

<h3>获取Map中的值</h3>
<%--${域名称.键名.key名称}--%>
<%--${域名称.键名["key名称"]}--%>
${sMap.name}<br/>
${sMap.user.age}<br/>

${sMap["name"]}<br/>

</body>
</html>

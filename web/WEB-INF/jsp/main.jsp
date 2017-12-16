<%@ page import="by.htp.library.entity.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 12/14/2017
  Time: 3:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Хренька, но я все же начинаю что-то понимать


<h2>
    <% User user = (User)request.getAttribute("myuser");%>
    <%=user.getName()%>
    инфа обо всех пользователях<br/>

        </h2>
<form action="/FrontController" method="post">
    <input name="login" value=<%=user.getLogin()%>><br>
    <input name="password" value=<%=user.getPassword()%>><br>
    <input type="hidden" name = "command" value="getAll"/><br>
    <input type="submit" name="sign" value="sign">
</form>


</body>
</html>

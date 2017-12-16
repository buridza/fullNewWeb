<%@ page import="java.util.ArrayList" %>
<%@ page import="by.htp.library.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Denis
  Date: 12/16/2017
  Time: 2:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%ArrayList<User> users = (ArrayList<User>)request.getAttribute("myuser");%>

   <% for (User u:users){ %>
    <%=u%><br>
<%}%>
hello, admin
</body>
</html>

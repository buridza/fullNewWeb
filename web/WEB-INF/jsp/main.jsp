<%@ page import="by.htp.library.entity.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

    <jsp:useBean id="myuser" scope ="session" class="by.htp.library.entity.User"/>
    <jsp:getProperty name="myuser" property="name"/>

    инфа обо всех пользователях<br/>

</h2>
<form action="/FrontController" method="post">
    <c:out value="${pageContext.request.getAttribute('myuser')}"/>
    <%User user = (User) request.getAttribute("myuser");%>
    <input type="hidden" name="login" value=<%=user.getLogin()%>><br>
    <input type="hidden" name="password" value=<%=user.getPassword()%>><br>
    <input type="hidden" name="command" value="getAll"/><br>
    <input type="submit" name="sign" value="sign">
   <%-- <c:out value="${name}"/>--%>
    
</form>


</body>
</html>

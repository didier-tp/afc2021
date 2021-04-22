<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
    <form action="MvcServlet" method="POST">
        <input type="hidden" name="tache" value="login" />
        username=<input name="username" type="text" value="${loginBean.username}" /><br/>
        password=<input name="password" type="text" value="${loginBean.password}"/><br/>
        <input type="submit" value="login" />
     </form>
     message : <b>${loginBean.message}</b> <br/>
     <%@ include file="piedPage.jsp" %>
</body>
</html>
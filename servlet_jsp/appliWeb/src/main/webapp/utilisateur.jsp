<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>utilisateur</title>
</head>
<body>
     message : <b>${loginBean.message}</b> <br/>
     <h3>utilisateur connect�:</h3>
     <i>${loginBean.user.username}</i> <br/>
   <!--  <i>${requestScope.loginBean.user.username}</i> <br/>  -->
     <b>${loginBean.user.email}</b> <br/>
   <!--   <b>${sessionScope.user.email}</b> <br/> -->
     <%@ include file="piedPage.jsp" %>
</body>
</html>
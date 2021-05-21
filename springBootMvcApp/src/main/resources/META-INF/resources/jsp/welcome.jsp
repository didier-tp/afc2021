<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css" />
  <link rel="stylesheet" href="../css/styles.css" />
<title>welcome</title>
</head>
<body>
<div class="container-fluid">
<%@include file="_header.jsp" %>
    <h1>Welcome </h1>
    <p>message=<b>${message}</b></p>
    <hr/>
    <a href="to-login">login (client)</a><br/>
    <a href="to-ex-ajax">exemple ajax</a><br/>
    <hr/>
    <a href="session-end">fin de session / deconnexion</a><br/>
    num session http/jee= <%=session.getId()%>
<%@include file="_footer.jsp" %>   
</div>	 
</body>
</html>
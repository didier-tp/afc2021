<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>addInCaddy</title>
</head>
<body>
   <form action="MvcServlet" method="POST">
        <input type="hidden" name="tache" value="addInCaddy" />
        produit=<input name="produit" type="text"  /><br/>
        <input type="submit" value="ajouter dans caddy" />
     </form>
     message : <b>${caddyBean.message}</b> <br/>
     <%@ include file="piedPage.jsp" %>
</body>
</html>
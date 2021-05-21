<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css" />
  <link rel="stylesheet" href="../css/styles.css" />
<title>login</title>
</head>
<body>
<div class="container-fluid">
<%@include file="_header.jsp" %>
   <h3>login (client banque)</h3>
	<hr/>
	<form action="../compte/login" method="POST">
	    numClient : <input name="numClient" type="text" /> <br/>
	    <input  type="submit" value="identification client banque" /> <br/>
	    <input type="hidden"   name="${_csrf.parameterName}"      value="${_csrf.token}"/>
	</form>
<%@include file="_footer.jsp" %>
</div>	 
</body>
</html>
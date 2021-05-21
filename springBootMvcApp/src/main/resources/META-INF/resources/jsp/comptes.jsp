<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css" />
  <link rel="stylesheet" href="../css/styles.css" />
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid">
<%@include file="_header.jsp" %>
    numero client identifie: ${numClient}
	<h3>liste des comptes</h3>
	<table border="1" >
	<tr><th>numero</th><th>label</th><th>solde</th></tr>
		<c:forEach var="cpt" items="${listeCpt}">
			<tr><td>${cpt.numero}</td>
			    <td>${cpt.label}</td>
			    <td>${cpt.solde}</td>
			 </tr>
		</c:forEach>
	</table>
	<hr/>
	<a href="../virement/to-virement">nouveau virement</a><br/>
	<br/>
<%@include file="_footer.jsp" %>	
</div>	
</body>
</html>
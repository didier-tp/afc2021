<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>calculTva</title>
</head>
<%
String sHt = request.getParameter("ht");
String sTaux = request.getParameter("taux");
Double tva=0.0,ttc=0.0;
if(sHt!=null && sTaux!=null){
	Double ht = Double.parseDouble(sHt);
	Double taux = Double.parseDouble(sTaux);
	tva = ht * taux / 100;
	pageContext.setAttribute("tva", tva);
	ttc = ht + tva;
	pageContext.setAttribute("ttc", ttc);
}else{
	//valeur par defaut:
	sHt="200";
	sTaux="0";
}
%>
<body>
      <h3>calcul de tva</h3>
      <form method="POST">
	      <label>ht:</label><input type="text" name="ht" value="<%=sHt%>"> <br/>
	      <label>taux tva:</label><input type="text" name="taux" value="<%=sTaux%>"> <br/>
	      <input type="submit" value="calculer tva"> 
    </form>
    tva (v1)=<%=tva%> <br/>
    tva (v2)=${pageScope.tva} <br/>
    tva (v3)=<fmt:formatNumber value="${pageScope.tva}" pattern=".00" /> <br/>
    ttc=<%=ttc%> <br/>
    ttc (arrondi)=<b><fmt:formatNumber value="${pageScope.ttc}" pattern=".00" /></b> <br/>
    <%@ include file="piedPage.jsp" %>
</body>
</html>
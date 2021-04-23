<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.Date,java.text.SimpleDateFormat"
    %>
<%
Date date= new Date();
SimpleDateFormat f =  new SimpleDateFormat("dd/MM/yyyy");
String sDate = f.format(date);
%>    
<p> pied de page , compteurConnexions= ${applicationScope.compteurConnexions} , username= ${sessionScope.user.username} , date = <%=sDate%> , <a href="index.html">retour index</a></p>
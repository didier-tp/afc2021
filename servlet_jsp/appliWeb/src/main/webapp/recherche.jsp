<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>recherche</title>
</head>
<body>
     <form action="MvcServlet" method="POST">
        <input type="hidden" name="tache" value="rechercheInfosPays" />
        nomPays (ex: france)=<input name="nomPays" type="text" /><br/>
        <input type="submit" value="rechercher infos sur pays" />
     </form>
     <!--  
     <%
     fr.afcepf.al35.web.model.RechercheBean rechercheB = 
         (fr.afcepf.al35.web.model.RechercheBean) 
                 request.getAttribute("rechercheBean");
     %>
     <%if(rechercheB!=null) {%>
     message : <i><%=rechercheB.getMessage()%></i> <br/>
     <%}%>
     -->
     message : <b>${rechercheBean.message}</b> <br/>
     population du pays : <b>${rechercheBean.pays.population}</b><br/>
     <%@ include file="piedPage.jsp" %>
</body>
</html>
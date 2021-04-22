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
        nomPays=<input name="nomPays" type="text" /><br/>
        <input type="submit" value="rechercher infos sur pays" />
     </form>
     message : <b>${rechercheBean.message}</b> <br/>
     population du pays : <b>${rechercheBean.pays.population}</b>
</body>
</html>
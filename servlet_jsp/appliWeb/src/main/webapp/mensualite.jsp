<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>calcul de mensualite d'emprunt</title>
</head>
<%
String sMontant = request.getParameter("montant"); //montant
String sTauxPctParAn = request.getParameter("tauxPctParAn");//taux interet
String sNbMois = request.getParameter("nbMois");//duree , nombre de mensualite
Double mensualite=0.0;
if(sMontant!=null && ...){
	Double montant = Double.parseDouble(sMontant);
	Double tauxPctParAn = Double.parseDouble(sTauxPctParAn);
	Integer nbMois = Ineger.parseInt(sNbMois);
	Double tauxMensuel = (tauxPctParAn / 12 ) /100;
	mensualite = ( montant * tauxMensuel) / ( 1 - Math.pow( 1 + tauxMesuel , -nbMois));
}
%>
<body>

<!--  inclusion du sous fichier piedPage.jsp -->
</body>
</html>
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
if(sMontant!=null && sTauxPctParAn!=null && sNbMois!=null){
	Double montant = Double.parseDouble(sMontant);
	Double tauxPctParAn = Double.parseDouble(sTauxPctParAn);
	Integer nbMois = Integer.parseInt(sNbMois);
	Double tauxMensuel = (tauxPctParAn / 12 ) /100;
	mensualite = ( montant * tauxMensuel) / ( 1 - Math.pow( 1 + tauxMensuel , -nbMois));
}else{
	//valeurs par défaut:
	sMontant="0";
	sNbMois="36";
	sTauxPctParAn="1";
}
%>
<body>
 <h3>calcul de mensualite d'emprunt</h3>
      <form method="POST">
	      <label>montant emprunté:</label><input type="text" name="montant" value="<%=sMontant%>"> <br/>
	      <label>taux intérêt annuel (en%):</label><input type="text" name="tauxPctParAn" value="<%=sTauxPctParAn%>"> <br/>
	      <label>durée de l'emprunt = nombre de mensualités (nbMois):</label><input type="text" name="nbMois" value="<%=sNbMois%>"> <br/>
	      <input type="submit" value="calculer mensualite"> 
    </form>
    mensualite=<b><%=mensualite%></b> <br/>
<!--  inclusion du sous fichier piedPage.jsp -->
<%@ include file="piedPage.jsp" %>
</body>
</html>
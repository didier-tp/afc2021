<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css" />
  <link rel="stylesheet" href="../css/styles.css" />
  <script  src="../js/jquery-3.5.1.js"></script>
<title>ex-ajax</title>
<script>
   function chercherCouleursViaAjax(){
	   $.ajax({
		       url : '../rest/couleur/selonLangue?langue=fr',
		       type : 'GET' ,
		       success : function(result, status , xhr){ 
		               console.log("result:" + JSON.stringify(result));
		               $('#divA').html(JSON.stringify(result)).css("color",'blue');
		               $('#listeUl').empty();
		               for(let i in result){
		            	   var couleur= result[i];
		            	   $('#listeUl').append("<li>"+ couleur.name + " " + couleur.code +"</li>");
		               }
		           },
		       error : function(jqqXhr, status, erreur){
		    	       console.log("erreur:" + error);
		           }
		    });
   }
  </script>
</head>
<body>
<div class="container-fluid">
<%@include file="_header.jsp" %>
    <h1>Exemple ajax </h1>
    <div id="divA"></div>
    <hr/> 
    <button onclick="chercherCouleursViaAjax()">essai dom/js/ajax</button>
    <hr/>
    <ul id="listeUl">
    </ul>
<%@include file="_footer.jsp" %>   
</div>	 
</body>
</html>
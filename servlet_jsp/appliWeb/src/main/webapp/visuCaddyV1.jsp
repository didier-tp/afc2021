<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.List"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>visuCaddy</title>
</head>
<body>
	<table border="1" >
	<%
	List<String> caddy = (List<String>) session.getAttribute("caddy");
	if(caddy!=null){
	   for(String s : caddy) {%>
	      <tr><td><%=s%></td></tr> 
	   <%
	   }
	}
	 %>
	</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="../css/bootstrap.min.css" />
  <link rel="stylesheet" href="../css/styles.css" />
<title>virement</title>
<style>
    .error {
        color: red; font-weight: bold;
    }
</style>
</head>
<body>
<div class="container-fluid">
<%@include file="_header.jsp" %>
     <br/>
     <div class="card">
			<div class="card-header bg-primary text-white">
			   virement interne (mini-banque)
			 </div>
      <div class="card-body">
	  <form:form class="form-horizontal"
      action="doVirement"  modelAttribute="virementForm" method="POST">
			     <div class="form-group row">
				    <label class="control-label text-sm-right col-sm-4">numCptDeb:</label> <!-- <span id="spanIdProd"></span> -->
					<div class="col-sm-8">	
						<form:select path="numCptDeb" class="form-control">
	              <form:options items="${listeCpt}" itemLabel="label" itemValue="numero"/>
	            </form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label text-sm-right col-sm-4">numCptCred:</label>
					<div class="col-sm-8">
						<form:select path="numCptCred" class="form-control" > 
	                         <form:options items="${listeCpt}" itemLabel="label" itemValue="numero"/>
	                    </form:select>
					</div>
				</div>
				<div class="form-group row">
					<label class="control-label text-sm-right col-sm-4">montant:</label>
					<div class="col-sm-8">
					<form:input path="montant" class="form-control" /> <form:errors path="montant" cssClass="error"/>
					</div>
				</div>
				
				<div class="form-group row">
					  <div class="col-sm-8 offset-sm-4">
					     <input  type="submit" class="btn btn-primary" value="effectuer virement" />
					  </div>
					  
				 </div>
			 </form:form>
		  </div><!-- end of card-body -->
	  </div><!-- end of card -->
<br/>
<%@include file="_footer.jsp" %>
</div>		
</body>
</html>
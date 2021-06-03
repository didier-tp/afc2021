function doConversion(){
	
	var montant = Number(document.getElementById("txtMontant").value);
	var deviseSource = document.getElementById("txtDeviseSource").value;
	var deviseCible = document.getElementById("txtDeviseCible").value;
	console.log("doConversion() appelee avec montant= " + montant);
	
	var url = "http://localhost:8585/serverRest/devise-api-rest/devise/conversion?amount="
	            +montant+"&source="+deviseSource+
                "&target="+deviseCible;

    var callback = function(data){
	   console.log("sucess data=" + data);
       var resConv = JSON.parse(data);
       var montantConverti = resConv.result;
       document.getElementById("spanRes").innerHTML="<b>"+montantConverti+"</b>";
    }

    var errCallback = function(data){
	   console.log("erreur=" + data);
    }

	makeAjaxGetRequest(url,callback,errCallback) ;
	
}


function doAjout(){
	
	var change = Number(document.getElementById("txtChange").value);
	var code = document.getElementById("txtCode").value;
	var nom = document.getElementById("txtNom").value;

	
	var url = "http://localhost:8585/serverRest/devise-api-rest/devise"

    var callback = function(data){
	   console.log("sucess data=" + data);
       var message ="donnees sauvegardees cote serveur=" + data;
       document.getElementById("spanMessage").innerHTML="<b>"+message+"</b>";
    }

    var errCallback = function(data){
	   console.log("erreur=" + data);
       var message = (JSON.parse(data)).message;
       document.getElementById("spanMessage").innerHTML="<b>"+message+"</b>";
    }

    //var jsDeviseObject = {code : code , nom ; nom , change : change };
    var jsDeviseObject = {code , nom , change };
    var jsonData = JSON.stringify(jsDeviseObject);

	makeAjaxPostRequest(url,jsonData,callback,errCallback) ;
	
}
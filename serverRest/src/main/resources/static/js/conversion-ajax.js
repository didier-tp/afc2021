function doConversion(){
	
	var montant = Number(document.getElementById("txtMontant").value);
	var deviseSource = document.getElementById("txtDeviseSource").value;
	var deviseCible = document.getElementById("txtDeviseCible").value;
	console.log("doConversion() appelee avec montant= " + montant);
	
	var url = "./devise-api-rest/devise/conversion?amount="
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
var traiterReponse = function(response) {
	//response ici au format "json string"
	var zoneResultat = document.getElementById("spanRes");
	var jsDevise = JSON.parse(response);
	zoneResultat.innerHTML = jsDevise.rate; //ou .change
}
function onSearchDevise() {
	var zoneSaisieCode = document.getElementById("txtCodeDevise");
	var codeDevise = zoneSaisieCode.value;
	console.log("codeDevise=" + codeDevise);
	var urlWsGet = "./devise-api/public/devise/" + codeDevise;
	makeAjaxGetRequest(urlWsGet, traiterReponse); //non bloquant (asynchrone)
	//....
}
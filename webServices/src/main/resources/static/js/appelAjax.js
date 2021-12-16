function parseJwt (token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
    return jsonPayload;
    //return JSON.parse(jsonPayload);
};

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

function doAjout(){
	
	var change = Number(document.getElementById("txtChange").value);
	var code = document.getElementById("txtCode").value;
	var nom = document.getElementById("txtNom").value;

	
	var url = "./devise-api/private/devise"

    var callback = function(data){
	   console.log("success data=" + data);
       var message ="donnees sauvegardees cote serveur=" + data;
       document.getElementById("spanMessage").innerHTML="<b>"+message+"</b>";
    }

    var errCallback = function(data){
	   console.log("erreur=" + data);
       var message = (JSON.parse(data)).message;
       document.getElementById("spanMessage").innerHTML="<b>"+message+"</b>";
    }

    var jsDeviseObject = {code : code , name : nom , rate : change };
    var jsonData = JSON.stringify(jsDeviseObject);

    var token = sessionStorage.getItem("token");
    makeAjaxPostRequest(url,jsonData,callback,errCallback,token) ;
	//makeAjaxPostRequest(url,jsonData,callback,errCallback,tokenGlobal) ;
	
}

function doLogin(){

	var username = document.getElementById("txtUsername").value;
	var password = document.getElementById("txtPassword").value;

	
	var url = "./devise-api/public/login"

    var callback = function(data){
	   console.log("success data=" + data);
       var jwtToken = (JSON.parse(data)).token;
       //tokenGlobal=jwtToken;
       sessionStorage.setItem("token",jwtToken);
       var message ="reponse login=" + data + " payload token=" + parseJwt(jwtToken);
       document.getElementById("spanMessageLogin").innerHTML="<b>"+message+"</b>";
    }

    var errCallback = function(data){
	   console.log("erreur=" + data);
       var message = (JSON.parse(data)).message;
       sessionStorage.setItem("token",null);
       document.getElementById("spanMessageLogin").innerHTML="<b>"+message+"</b>";
    }

    var jsLoginRequestObject = {username , password};
    var jsonData = JSON.stringify(jsLoginRequestObject);

	makeAjaxPostRequest(url,jsonData,callback,errCallback) ;
	
}
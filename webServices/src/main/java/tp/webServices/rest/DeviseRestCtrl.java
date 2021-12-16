package tp.webServices.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.webServices.delegate.RefreshDevise;
import tp.webServices.dto.Currency;
import tp.webServices.dto.DtoUtil;
import tp.webServices.dto.MessageGenerique;
import tp.webServices.entity.Devise;
import tp.webServices.service.DeviseService;


@RestController
@RequestMapping(value="/devise-api" , headers="Accept=application/json")
public class DeviseRestCtrl {
	
	private DeviseService deviseService;
	
	private RefreshDevise refreshDevise;//appel de WS externe pour refresh values in db

	@Autowired
	public DeviseRestCtrl(DeviseService deviseService,
			              RefreshDevise refreshDevise) {
		//injection de dépendance par constructeur
		this.deviseService = deviseService;
		this.refreshDevise=refreshDevise;
	}
	
	//http://localhost:8484/webServices/devise-api/private/refresh
	@GetMapping(value="/private/refresh")
	public MessageGenerique refreshValues() {
		List<Devise> devises = this.refreshDevise.refreshDeviseValuesInDataBase();
		return new MessageGenerique("refresh ok",devises.toString());
	}
	
	//RECHERCHE UNIQUE selon RESOURCE-ID:
	//http://localhost:8484/webServices/devise-api/public/devise/EUR
	@GetMapping(value="/public/devise/{codeDevise}")
	public Currency getDeviseByName(@PathVariable("codeDevise") String codeDevise) {
	    Devise devise = deviseService.rechercherDeviseParCode(codeDevise);
	    
	    //conversion entity vers dto via constructeur
	    return new Currency(devise.getCode(),devise.getNom(),devise.getChange());
	    
	    //BeanUtils.copyProperties(sourceObj, targetObj)
	}
	
	//RECHERCHE MULTIPLE :
	//http://localhost:8484/webServices/devise-api/public/devise
	@GetMapping(value="/public/devise" )
	public List<Currency> getDevisesByCriteria(){
	    return DtoUtil.deviseListToCurrencyList(
	    		deviseService.rechercherToutesDevises());
	}
	
	//POST
	//http://localhost:8484/webServices/devise-api/private/devise
	//avec { "code" : "DDK" , "name" : "couronne danoise" , "rate" : 7.77 }
	//dans partie body de la requête entrante
	@PostMapping(value="/private/devise" )
	public ResponseEntity<?> postDevise(@RequestBody Currency c){
		   String codeDevise = c.getCode();
		   if(deviseService.existeOuPas(codeDevise)) {
			   /*
			   Map<String,Object> msgErreur = new HashMap<>();
			   msgErreur.put("message", "autre devise avec meme code dejà existante");
			   return new ResponseEntity<Map<String,Object>>
			                    (msgErreur, HttpStatus.CONFLICT);
			   */
			   return new ResponseEntity<MessageGenerique>
                      (new MessageGenerique("autre devise avec meme code dejà existante") , 
                       HttpStatus.CONFLICT);
		   }else {
		      deviseService.sauvegarderDevise(
		    		   new Devise(c.getCode(),c.getName(),c.getRate()));
		      return new ResponseEntity<Currency>(c, HttpStatus.CREATED);
		   }
	}
	
	//PUT
	//http://localhost:8484/webServices/devise-api/private/devise
	//avec { "code" : "DDK" , "name" : "couronne du danemark" , "rate" : 8.88 }
	//dans partie body de la requête entrante
	@PutMapping(value="/private/devise" )
	public ResponseEntity<?> putDevise(@RequestBody Currency c){
		 String codeDevise = c.getCode();
		   if(deviseService.existeOuPas(codeDevise)) {		
			   deviseService.sauvegarderDevise(
					      new Devise(c.getCode(),c.getName(),c.getRate()));
			   return new ResponseEntity<Currency>(c, HttpStatus.OK);
		   }else {
			  return new ResponseEntity<MessageGenerique>
               (new MessageGenerique("pas de devise existante a mettre a jour","pour code="+codeDevise) , 
                HttpStatus.NOT_FOUND);		   
		   }
	}
	
	//DELETE
	//http://localhost:8484/webServices/devise-api/private/devise/DDK
	@DeleteMapping(value="/private/devise/{codeDevise}" )
	public ResponseEntity<?> deleteDevise(
			     @PathVariable("codeDevise") String codeDevise){
		   if(deviseService.existeOuPas(codeDevise)) {
			   this.deviseService.supprimerDeviseParCode(codeDevise);
			   Map<String,Object> msgOk = new HashMap<>();
			   msgOk.put("message", "suppression bien effectuee");
			   return new ResponseEntity<Map<String,Object>>(msgOk, HttpStatus.OK);
		   }else {
				  return new ResponseEntity<MessageGenerique>
	               (new MessageGenerique("pas de devise existante a supprimer","pour code="+codeDevise) , 
	                HttpStatus.NOT_FOUND);		   
			   }	   
	}
	
	

}

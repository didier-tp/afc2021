package tp.webServices.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tp.webServices.entity.Devise;
import tp.webServices.service.DeviseService;


@RestController
@RequestMapping(value="/devise-api" , headers="Accept=application/json")
public class DeviseRestCtrl {
	
	private DeviseService deviseService;

	public DeviseRestCtrl(DeviseService deviseService) {
		//injection de dépendance par constructeur
		this.deviseService = deviseService;
	}
	
	//RECHERCHE UNIQUE selon RESOURCE-ID:
	//http://localhost:8484/webServices/devise-api/public/devise/EUR
	@GetMapping(value="/public/devise/{codeDevise}")
	public Devise getDeviseByName(@PathVariable("codeDevise") String codeDevise) {
	    return deviseService.rechercherDeviseParCode(codeDevise);
	}
	
	//RECHERCHE MULTIPLE :
	//http://localhost:8484/webServices/devise-api/public/devise
	@GetMapping(value="/public/devise" )
	public List<Devise> getDevisesByCriteria(){
	    return deviseService.rechercherToutesDevises();
	}
	
	//POST
	//http://localhost:8484/webServices/devise-api/private/devise
	//avec { "code" : "DDK" , "nom" : "couronne danoise" , "change" : 7.77 }
	//dans partie body de la requête entrante
	@PostMapping(value="/private/devise" )
	public ResponseEntity<Devise> postDevise(@RequestBody Devise d){
		   //v1 (à beaucoup améliorer)
		   deviseService.sauvegarderDevise(d);
		   return new ResponseEntity<Devise>(d, HttpStatus.OK);
	}
	
	

}

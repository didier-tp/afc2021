package tp.webServices.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

}

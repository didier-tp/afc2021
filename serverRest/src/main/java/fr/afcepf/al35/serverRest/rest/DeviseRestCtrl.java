package fr.afcepf.al35.serverRest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al35.serverRest.entity.Devise;
import fr.afcepf.al35.serverRest.service.ServiceDevise;

@RestController
@RequestMapping(value="/devise-api-rest/devise" , headers="Accept=application/json")
public class DeviseRestCtrl {
	
	@Autowired
	private ServiceDevise serviceDevise;
	
	//localhost:8585/serverRest/devise-api-rest/devise/EUR
	@GetMapping("/{codeDevise}")
	public Devise getDeviseByCode(@PathVariable("codeDevise") String codeDevise) {
		return serviceDevise.rechercherDeviseParCode(codeDevise);
	}

}

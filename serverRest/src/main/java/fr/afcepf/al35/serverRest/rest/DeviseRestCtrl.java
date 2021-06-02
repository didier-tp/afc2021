package fr.afcepf.al35.serverRest.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al35.serverRest.dto.ResConversion;
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
	
	//localhost:8585/serverRest/devise-api-rest/devise
	//localhost:8585/serverRest/devise-api-rest/devise?changeMini=1.05
	@GetMapping("")
	public List<Devise> getDevisesByCriteria(
			  @RequestParam(value="changeMini",required=false) Double changeMini) {
		List<Devise> devises = serviceDevise.rechercherDevises();
		if(changeMini!=null) {
			devises= 
					devises.stream()
			       .filter((d)->d.getChange()>1.05)
			       .collect(Collectors.toList());
		}
		return devises;
	}
	
	//localhost:8585/serverRest/devise-api-rest/devise/conversion?amount=200&source=EUR&target=USD
		@GetMapping("/conversion")
		public ResConversion getResConversion(
				@RequestParam(value="amount") Double amount,
				@RequestParam(value="source") String source,
				@RequestParam(value="target") String target) {
			ResConversion resConv = new  ResConversion();
			resConv.setAmount(amount);
			resConv.setSource(source);
			resConv.setTarget(target);
			resConv.setResult(serviceDevise.convertir(amount, source, target));
			return resConv;
		}

}

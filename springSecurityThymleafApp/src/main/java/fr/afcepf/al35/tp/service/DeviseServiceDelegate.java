package fr.afcepf.al35.tp.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al35.tp.dto.Devise;
import fr.afcepf.al35.tp.dto.ResConversion;

//déléguation vers web service REST
@Component //ou bien @Service
public class DeviseServiceDelegate  implements DeviseService{
	
	private RestTemplate restTemplate;
	private String baseUrl = 
			"http://localhost:8585/serverRest/devise-api-rest/devise";

	public DeviseServiceDelegate() {
		restTemplate = new RestTemplate();
	}

	@Override
	public double convertir(double montant, String codeMsource, String codeMcible) {
		String url = baseUrl + "/conversion?amount=" + montant 
				             + "&source="+codeMsource 
				             + "&target="+codeMcible ; 
		ResConversion resConv = restTemplate.getForObject(url,ResConversion.class);
		return resConv.getResult();
	}

	@Override
	public List<Devise> listeDevises() {
		String url = baseUrl; 
		Devise[] tabDevises = restTemplate.getForObject(url,Devise[].class);
        return Arrays.asList(tabDevises);
	}

}

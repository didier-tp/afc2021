package fr.afcepf.al35.tp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al35.tp.dto.Devise;
import fr.afcepf.al35.tp.dto.LoginRequest;
import fr.afcepf.al35.tp.dto.LoginResponse;
import fr.afcepf.al35.tp.dto.ResConversion;

//déléguation vers web service REST
@Component //ou bien @Service
public class DeviseServiceDelegate  implements DeviseService{
	
	public static String token=null;
	
	private RestTemplate restTemplate;
	private String baseUrl = 
			"http://localhost:8585/serverRest/devise-api-rest";

	public DeviseServiceDelegate() {
		restTemplate = initRestTemplate();
	}
	
	public RestTemplate initRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();

        List<ClientHttpRequestInterceptor> interceptors
          = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new RestTemplateHeaderModifierInterceptor());
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

	@Override
	public double convertir(double montant, String codeMsource, String codeMcible) {
		String url = baseUrl + "/public/devise/conversion?amount=" + montant 
				             + "&source="+codeMsource 
				             + "&target="+codeMcible ; 
		ResConversion resConv = restTemplate.getForObject(url,ResConversion.class);
		return resConv.getResult();
	}

	private void essaiTemporaire() {
		LoginRequest loginRequest = new LoginRequest("admin1","pwd1");
		String urlLogin = baseUrl + "/public/login" ;
		LoginResponse loginResponse =
		restTemplate.postForObject(urlLogin, loginRequest, LoginResponse.class);
		System.out.println("loginResponse="+loginResponse);
		token=loginResponse.getToken();
		//-------- tenter de supprimer la devise JPY (en TP)
		try {
			String urlDelete = baseUrl + "/private/devise/JPY" ;
			restTemplate.delete(urlDelete);
		} catch (RestClientException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public List<Devise> listeDevises() {
		essaiTemporaire();
		String url = baseUrl + "/public/devise"; 
		Devise[] tabDevises = restTemplate.getForObject(url,Devise[].class);
        return Arrays.asList(tabDevises);
	}

}

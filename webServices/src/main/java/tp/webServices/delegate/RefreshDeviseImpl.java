package tp.webServices.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import tp.webServices.dto.FixerIoResponse;
import tp.webServices.entity.Devise;
import tp.webServices.service.DeviseService;

@Service
public class RefreshDeviseImpl implements RefreshDevise{
	
	private final WebClient webClient;
	private final DeviseService deviseService;
	
	private String tempApiKey="26ca93ee7fc19cbe0a423aaa27cab235";//formateur didier defrance
	private String fixerApiUrl="http://data.fixer.io/api/latest"
	                           +"?access_key="+tempApiKey; //apiKey may be passed in header with other api

    @Autowired
    public RefreshDeviseImpl(WebClient.Builder builder,
    		                 DeviseService deviseService) {
        this.webClient = builder
                .baseUrl(fixerApiUrl)
                //.defaultHeader("api_key", tempApiKey) //not possible with fixer.io api
                .build();
		this.deviseService = deviseService;
    }


	@Override
	public List<Devise> retreiveRecentDeviseValues() {
		List<Devise> devises = new ArrayList<>();
		
		/*
		 Mono<String> reactiveStream = webClient.get()
	            .retrieve()
	            .bodyToMono(new ParameterizedTypeReference<String>() {});
	    String result = reactiveStream.block();
	    System.out.println("result="+result);
		 */
		//type de réponse brute attendue:
		/*
			{"success":true,"timestamp":1635959583,"base":"EUR","date":"2021-11-03",
			"rates":{"AED":4.254663,"AFN":105.467869,..., "EUR":1 , ...}}
		*/
		
		Mono<FixerIoResponse> reactiveStream = webClient.get()//.uri("/suiteUrlQuiVaBien")
	            .retrieve()
	            .bodyToMono(new ParameterizedTypeReference<FixerIoResponse>() {});
		FixerIoResponse fixerIoResponse = reactiveStream.block();
		
		/*
		ResponseEntity<FixerIoResponse> fixerIoResponseEntity= 
				webClient.get().retrieve()
				.toEntity(FixerIoResponse.class).block();
		
		FixerIoResponse fixerIoResponse = null;
		if(fixerIoResponseEntity.getStatusCode()==HttpStatus.OK) {
		 fixerIoResponse=fixerIoResponseEntity.getBody();
		}
		*/
		
	    System.out.println("result="+fixerIoResponse);
	    for(String deviseCode : fixerIoResponse.getRates().keySet()) {
	    	Double change=fixerIoResponse.getRates().get(deviseCode);
	    	String deviseName ="__"+deviseCode+"__"; //au mieux (valeur à améliorer ultérieurement)
	    	Devise d = new Devise(deviseCode,deviseName,change);
	    	devises.add(d);
	    }
	    return devises;
	}

	@Override
	@Transactional
	public List<Devise> refreshDeviseValuesInDataBase() {
		List<Devise> freshDevises = this.retreiveRecentDeviseValues();
		for(Devise d : freshDevises) {
			boolean existing = deviseService.existeOuPas(d.getCode());
			if(existing) {
				Devise ed = deviseService.rechercherDeviseParCode(d.getCode());
				ed.setChange(d.getChange());
				//automatic update/save in transactional context
			}else {
				//cela fonctionne , mais trop de monnaies non significatives
				//deviseService.sauvegarderDevise(d);
			}
		}
		return freshDevises;	
	}

}

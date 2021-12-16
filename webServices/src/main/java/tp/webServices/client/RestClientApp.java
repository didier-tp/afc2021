package tp.webServices.client;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;
import tp.webServices.dto.Currency;

public class RestClientApp {

	public static void main(String[] args) {
		posterNouvelleDevise();

	}

	private static void posterNouvelleDevise() {
		WebClient.Builder builder = WebClient.builder();
		String baseUrl="http://localhost:8484/webServices/devise-api";
		WebClient webClient = builder
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
		
		//créer une instance du DTO Currency
		//avec les valeurs 
		//{ "code" : "DDK" , "name" : "couronne danoise" , "rate" : 7.77 }
		
		Currency currencyDDK = new Currency("DDK","couronne danoise" , 7.77);
		
		//envoyer cela via un appel en POST
		Mono<Currency> reactiveStream = webClient.post().uri("/private/devise")
				.body(Mono.just(currencyDDK), Currency.class)
				.retrieve()
	            .bodyToMono(Currency.class)
	            .onErrorReturn(new Currency("?","not saved !!",0.0));
		Currency savedCurrency = reactiveStream.block();
		
		System.out.println("savedCurrency=" + savedCurrency.toString());
		}

}

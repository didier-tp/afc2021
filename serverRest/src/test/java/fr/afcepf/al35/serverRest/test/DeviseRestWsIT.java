package fr.afcepf.al35.serverRest.test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al35.serverRest.dto.LoginRequest;
import fr.afcepf.al35.serverRest.dto.LoginResponse;
import fr.afcepf.al35.serverRest.entity.Devise;

/* cette classe à un nom qui commence ou se termine par IT (et par par Test)
* car c'est un Test d'Integration qui ne fonctionne que lorsque toute l'application
* est entièrement démarrée  .*/
public class DeviseRestWsIT {
	
	private static RestTemplate restTemplate; //objet technique de Spring pour test WS REST
	
	private static String BASE_URL ="http://localhost:8585/serverRest/devise-api-rest";
	
	//pas de @Autowired ni de @RunWith
	//car ce test EXTERNE est censé tester le WebService sans connaître sa structure interne
	// (test BOITE_NOIRE)
	@BeforeAll
	public static void init(){
	     //restTemplate = new RestTemplate();
		 restTemplate = RestTemplateHeaderModifierInterceptor.initRestTemplate(); //with jwt token interceptor
	}
	
	@Test
	public void testGetDeviseByCode(){
		final String uri = BASE_URL + "/public/devise/EUR";
		String resultAsJsonString = restTemplate.getForObject(uri, String.class);
		System.out.println("json string of devise EUR via rest: " + resultAsJsonString);
	
		Devise d1 = restTemplate.getForObject(uri, Devise.class);
		System.out.println("devise EUR via rest: " + d1);
		Assertions.assertEquals(d1.getCode(),"EUR");
	}
	
	@Test
	public void testGetAllDevises(){
		final String uri = BASE_URL + "/public/devise";
		Devise[] tabDevises = restTemplate.getForObject(uri, Devise[].class);
		Assertions.assertNotNull(tabDevises);
		List<Devise> listeDevises = Arrays.asList(tabDevises); 
		System.out.println("devises via rest: " + listeDevises);
		Assertions.assertTrue(listeDevises.size()>=0);
	}
	

	public void login(){
		final String uri = BASE_URL + "/public/login";
		//post/envoi:
		LoginRequest loginRequest = new LoginRequest("user1","pwd1");
		LoginResponse loginResponse =
		restTemplate.postForObject(uri, loginRequest, LoginResponse.class);
		System.out.println("loginResponse via rest: " + loginResponse.toString());
		Assertions.assertTrue(loginResponse.getOk());
		RestTemplateHeaderModifierInterceptor.token = loginResponse.getToken();
	}
   
	
	
	@Test
	public void testPostDeviseAfterLogin(){
		login();
		final String uri = BASE_URL + "/private/devise";;
		//post/envoi:
		Devise nouvelleDevise = new Devise("CM"+(int) (Math.random()*1000),"MonnaieXy",1.23456);
		Devise nouvelleDeviseSauvegardee =
		restTemplate.postForObject(uri, nouvelleDevise, Devise.class);
		System.out.println("nouvelleDeviseSauvegardee via rest: " + nouvelleDeviseSauvegardee.toString());
		Assertions.assertEquals(nouvelleDeviseSauvegardee.getNom(),"MonnaieXy");
	}
    
}

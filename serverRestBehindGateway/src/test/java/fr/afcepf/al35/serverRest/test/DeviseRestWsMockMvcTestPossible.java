package fr.afcepf.al35.serverRest.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al35.serverRest.ServerRestApplication;
import fr.afcepf.al35.serverRest.entity.Devise;

/*
 if @WebMvcTest(ServerRestApplication.class )
 ==> need to mock @Service behind @RestController with Mockito
 
 if @SpringBootTest(classes= {ServerRestApplication.class})
and @AutoConfigureMockMvc
==> can use autoriwed @Service & @Repository behind @RestController

https://examples.javacodegeeks.com/spring-boot-mockmvc-tutorial/
https://www.baeldung.com/oauth-api-testing-with-spring-mvc
 */


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {ServerRestApplication.class})
@AutoConfigureMockMvc
@ActiveProfiles("initDataSet")
public class DeviseRestWsMockMvcTestPossible {
	
	@Autowired
	private MockMvc mvc;
	
	//NB: cette URL relative ne tient compte ici que des valeurs des @RequestMapping
	//pas ne tient pas compte de context/servlet path.
	//autrement dit (en relatif vis à vis du context.serlet path s'il existe).
	private static String RELATIVE_BASE_URL ="/devise-api-rest";
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	
	@Test
	public void testGetDeviseByCode() throws Exception {
		final String uri = RELATIVE_BASE_URL + "/public/devise/EUR";
		mvc.perform(get(uri)
				.accept(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.code", is("EUR") ))
				.andDo(print());
		
	}
	
	@Test
	public void testGetAllDevises() throws Exception {
		final String uri = RELATIVE_BASE_URL + "/public/devise";
		mvc.perform(get(uri)
				.accept("application/json")
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1)) ))
				.andDo(print());
		
	}
	
	
	
	/*
	@Test
	public void givenNoToken_whenPostNewDevise_thenUnauthorized() throws Exception {
		final String uri = RELATIVE_BASE_URL + "/private/devise";
		Devise nouvelleDevise = new Devise("CM"+(int) (Math.random()*1000),"MonnaieXy",1.23456);
		mvc.perform(post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(nouvelleDevise))
				)
				.andExpect(status().isUnauthorized());
	}*/
	

	@Test
	public void testPostNewDevise() throws Exception {
		/*
		String accessToken = obtainAccessToken("user1","pwd1");
		System.out.println("accessToken="+accessToken);
		*/
		final String uri = RELATIVE_BASE_URL + "/private/devise";
		Devise nouvelleDevise = new Devise("CM"+(int) (Math.random()*1000),"MonnaieXy",1.23456);
		mvc.perform(post(uri)
				//.header("Authorization", "Bearer " + accessToken)
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(nouvelleDevise))
				)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.nom", is("MonnaieXy") ))
				.andDo(print());
		
	}

	
}




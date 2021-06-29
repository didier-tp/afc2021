package fr.afcepf.al35.serverRest.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

import fr.afcepf.al35.serverRest.ServerRestApplication;

/*
 if @WebMvcTest(ServerRestApplication.class )
 ==> need to mock @Service behind @RestController with Mockito
 
 if @SpringBootTest(classes= {ServerRestApplication.class})
and @AutoConfigureMockMvc
==> can use autoriwed @Service & @Repository behind @RestController

https://examples.javacodegeeks.com/spring-boot-mockmvc-tutorial/
 */


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes= {ServerRestApplication.class})
@AutoConfigureMockMvc
@ActiveProfiles("initDataSet")
public class DeviseRestWsMockMvcTest {
	
	@Autowired
	private MockMvc mvc;
	
	private static String RELATIVE_BASE_URL ="/serverRest/devise-api-rest";
	
	//@Test
	public void testGetDeviseByCode() throws Exception {
		final String uri = RELATIVE_BASE_URL + "/public/devise/EUR";
		mvc.perform(get(uri)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1) ))
				.andExpect(jsonPath("$[0].code", is("EUR") ));
		
	}
	
	//@Test
	public void testGetAllDevises() throws Exception {
		final String uri = RELATIVE_BASE_URL + "/public/devise";
		mvc.perform(get(uri)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
	}
	
	
}




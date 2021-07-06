package fr.afcepf.al35.serverRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class ServerRestApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ServerRestApplication.class, args);
		
		SpringApplication app = new SpringApplication(ServerRestApplication.class);
		
		/*
		 Profiles:
		   - initDataSet : pour initialiser un jeu de données
		   - noAuth ou bien  asOAuth2ResourceServer
		 */
		
		//app.setAdditionalProfiles("initDataSet","swagger","noAuth");
		app.setAdditionalProfiles("initDataSet","asOAuth2ResourceServer");
		
		
		ConfigurableApplicationContext context = app.run(args);
		System.out.println("version ServerRestBehindGateway ...");
		System.out.println("http://localhost:8585/serverRest/index.html");
	}

}

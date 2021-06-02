package fr.afcepf.al35.serverRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerRestApplication.class, args);
		System.out.println("http://localhost:8585/serverRest/index.html");
	}

}

package fr.afcepf.al35.serverSoap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerSoapApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSoapApplication.class, args);
		System.out.println("http://localhost:8484/serverSoap");
	}

}

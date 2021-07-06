package tp.oauth2client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyOAuth2ClientApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(MyOAuth2ClientApplication.class, args);
		System.out.println("http://localhost:8081/index.html");
	}

}
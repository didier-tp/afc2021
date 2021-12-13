package tp.webServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServicesApplication.class, args);
		System.out.println("http://localhost:8484/webServices");
	}

}

package fr.afcepf.al35.injection;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InjectionApplication {

	public static void main(String[] args) {
		//SpringApplication.run(InjectionApplication.class, args);
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InjectionApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
		
		System.out.println("http://localhost:8181/injection");
	}

}

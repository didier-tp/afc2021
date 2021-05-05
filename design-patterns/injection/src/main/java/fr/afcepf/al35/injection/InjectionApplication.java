package fr.afcepf.al35.injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InjectionApplication {

	public static void main(String[] args) {
		//SpringApplication.run(InjectionApplication.class, args);
		
		/*
		SpringApplicationBuilder builder = new SpringApplicationBuilder(InjectionApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
        */
		
		SpringApplication app = new SpringApplication(InjectionApplication.class);
		app.setAdditionalProfiles("francais","profile2");
		ConfigurableApplicationContext context = app.run(args);
		
		System.out.println("http://localhost:8181/injection");
	}

}

package fr.afcepf.al35.tp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

//NB: @SpringBootApplication est un équivalent
//de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package
@SpringBootApplication
//NB: via le @EnableAutoConfiguration, application.properties sera analysé
//NB: cette classe doit être dans tp pour que le @ComponentScan automatique
// scrute tous les sous packages tp.dao, tp.service , ...
public class MySpringBootApplication extends SpringBootServletInitializer {
public static void main(String[] args) {
	//SpringApplication.run(MySpringBootApplication.class, args);
	SpringApplication app = new SpringApplication(MySpringBootApplication.class);
	app.setAdditionalProfiles("initData");
	ConfigurableApplicationContext context = app.run(args);
	System.out.println("http://localhost:8080/myJsfSpringBootApp");
}

}

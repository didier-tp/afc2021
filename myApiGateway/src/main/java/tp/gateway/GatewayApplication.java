package tp.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.security.oauth2.gateway.TokenRelayGatewayFilterFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
	
	@Autowired
	private TokenRelayGatewayFilterFactory filterFactory;
	
	@Bean
	public GatewayFilter tokenRelay() {
		return filterFactory.apply(); //To use in application.yml with TokenRelay
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
		System.out.println("http://localhost:9999/index.html");
	}

}
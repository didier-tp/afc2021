package tp.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig  {
	
	@Bean
	   public SecurityWebFilterChain filterChain(ServerHttpSecurity http) {
	      /*http.authorizeExchange(exchanges -> exchanges.anyExchange().authenticated())
	         .oauth2Login(withDefaults());
	         */
	      http.csrf().disable();
	      return http.build();
	   }
	

}
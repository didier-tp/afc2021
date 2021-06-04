package fr.afcepf.al35.serverRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import fr.afcepf.al35.serverRest.util.JwtAuthenticationFilter;
import fr.afcepf.al35.serverRest.util.MyNoAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//necessary for @PreAuthorize("hasRole('ADMIN or ...')")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("user1").password(passwordEncoder.encode("pwd1")).roles("USER")
		.and().withUser("admin1").password(passwordEncoder.encode("pwd1")).roles("ADMIN")
		.and().withUser("user2").password(passwordEncoder.encode("pwd2")).roles("USER")
		.and().withUser("admin2").password(passwordEncoder.encode("pwd2")).roles("ADMIN");
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private MyNoAuthenticationEntryPoint unauthorizedHandler;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/favicon.ico", "/**/*.png", "/**/*.gif", "/**/*.svg",
		"/**/*.jpg", "/**/*.html", "/**/*.css", "/**/*.js").permitAll()
		.antMatchers(HttpMethod.POST,"/devise-api-rest/public/login").permitAll()
		.antMatchers("/devise-api-rest/public/**").permitAll()
		.antMatchers("/devise-api-rest/private/**").authenticated()
		.and().cors() //enable CORS (avec @CrossOrigin sur class @RestController)
		.and().csrf().disable()
		// If the user is not authenticated, returns 401
		.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
		// This is a stateless application, disable sessions
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		// Custom filter for authenticating users using tokens
		.addFilterBefore(jwtAuthenticationFilter,
		UsernamePasswordAuthenticationFilter.class);
	}
}
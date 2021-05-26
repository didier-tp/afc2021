package fr.afcepf.al35.tp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)//necessary for @PreAuthorize("hasRole('ADMIN or ...')")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	    @Autowired
	    private BCryptPasswordEncoder passwordEncoder;
	    
	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Autowired
	    public void globalUserDetails(final AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		  .withUser("user1").password(passwordEncoder.encode("pwduser1")).roles("USER").and()
		  .withUser("admin1").password(passwordEncoder.encode("pwdadmin1")).roles("ADMIN","USER").and()
		  .withUser("publisher1").password(passwordEncoder.encode("pwdpublisher1")).roles("PUBLISHER","USER").and()
		  .withUser("user2").password(passwordEncoder.encode("pwduser2")).roles("USER").and()
		  .withUser("admin2").password(passwordEncoder.encode("pwdadmin2")).roles("ADMIN").and()
		  .withUser("publisher2").password(passwordEncoder.encode("pwdpublisher2")).roles("PUBLISHER"); 
	    }
	  
	    	
	   @Override
	   protected void configure(HttpSecurity http) throws Exception {
	      http
	    	 .authorizeRequests()
	    	    .antMatchers("/",
	                 "/favicon.ico",
	                 "/**/*.png",
	                 "/**/*.gif",
	                 "/**/*.svg",
	                 "/**/*.jpg",
	                 "/**/*.css",
	                 "/**/*.js").permitAll()
		 		   .antMatchers("/mvc/hello/hello-world").permitAll()
		 		   .antMatchers("/app/to-welcome").permitAll()
		 		   .antMatchers("/app/session-end").permitAll()
		 		   .antMatchers("/app/to-ex-ajax").permitAll()
		 		   .antMatchers("/app/to-carousel").permitAll()
		 		   .anyRequest().authenticated()
		 		   .and().formLogin().permitAll()
	 	 		   .and().csrf();
	    }
	    
	}
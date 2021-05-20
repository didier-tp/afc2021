package fr.afcepf.al35.tp.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WelcomePageRedirect implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/")
        .setViewName("forward:/index.html");
    	//.setViewName("forward:/welcome.xhtml");
    	//.setViewName("forward:/p1.xhtml");
    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
  }
  
}

package fr.afcepf.al35.serverRest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Profile("swagger")
@EnableSwagger2
public class SwaggerConfig {
// avec <a href="./swagger-ui.html">description api rest via swagger 2</a>
// dans index.html
//et app.setAdditionalProfiles("initData","swagger");
//dans le main()
//et dépendances springfox-swagger2 , springfox-swagger-ui dans pom.xml
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(/* RequestHandlerSelectors.any() */
				RequestHandlerSelectors.basePackage("fr.afcepf.al35.serverRest.rest")).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("My Spring-Mvc devise REST APIs").version("1.0.0").build();
	}
}
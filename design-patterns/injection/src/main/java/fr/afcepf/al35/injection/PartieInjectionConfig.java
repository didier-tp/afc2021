package fr.afcepf.al35.injection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import fr.afcepf.al35.injection.ds.PseudoDataSource;
import fr.afcepf.al35.injection.ds.PseudoDataSourceV1;

@Configuration
//@EnableAspectJAutoProxy //à priori par defaut avec spring-boot-starter-aop
public class PartieInjectionConfig {

	public PartieInjectionConfig() {
	}
	
	@Bean
	public PseudoDataSource pseudoDataSource() {
		return new PseudoDataSourceV1();
		//ou bien 
		//return new PseudoDataSourceV2();
		//souvent en analysant un fichier .properties
	}

}

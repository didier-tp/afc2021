package fr.afcepf.al35.serverRest.test;

import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import fr.afcepf.al35.serverRest.dao.DaoDevise;

@Configuration
public class WithMockDaoConfig {

	 private static final Logger logger = LoggerFactory.getLogger(WithMockDaoConfig.class);

	    @Bean()
	    @Profile("mock-dao")
	    @Primary //for overriding default spring-data-jpa dao
	    public DaoDevise daoDeviseMock() {
	        logger.info("Mocking: {}", DaoDevise.class);
	        return Mockito.mock(DaoDevise.class);
	    }

}

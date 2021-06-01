package fr.afcepf.al35.serverSoap;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import fr.afcepf.al35.serverSoap.service.Conversion;



@Configuration
@EnableAutoConfiguration
@ImportResource({ "classpath:META-INF/cxf/cxf.xml" })
public class CxfConfig {

	@Autowired
    private ApplicationContext applicationContext;
	
	// Replaces the need for web.xml
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext context) {
        return new ServletRegistrationBean(new CXFServlet(), "/service/*");
    }
    
    @Autowired 
    private Conversion conversion; //service spring interne
    
    //@Autowired
    //private IS2 s2;
 
    // Replaces cxf-servlet.xml
    @Bean
    // <jaxws:endpoint id="tvaServiceEndpoint" implementor="#calculTvaImpl" address="/calculTva	"/>
    public EndpointImpl tvaServiceEndpoint() {
        Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
        EndpointImpl endpoint = new EndpointImpl(bus, conversion /* implementor */);
        endpoint.publish("/conversion");
        //URL soap complete:
        //http://localhost:8484/serverSoap/service/conversion
        //http://localhost:8484/serverSoap/service/conversion?wsdl
        return endpoint;
    }
}
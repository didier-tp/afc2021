package tp.core.bs;

import javax.jws.WebParam;
import javax.jws.WebService;

import tp.core.dto.ResCalculTva;

//NB: @WebService et @WebParam (ici ou ailleurs)
//seulement nécessaire pour vision externe WS-SOAP

@WebService 
public interface CalculTva {
	double tva(@WebParam(name="ht")double ht,
			   @WebParam(name="tauxTva") double tauxTva) ;
	double ttc(@WebParam(name="ht")double ht,
			   @WebParam(name="tauxTva") double tauxTva);
	ResCalculTva tvaEtTtc(@WebParam(name="ht")double ht,
			              @WebParam(name="tauxTva") double tauxTva);
	String getAuteur() ;
}

package tp.webServices.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import tp.webServices.dto.ResCalculTva;

//@WebService(targetNamespace = "http://service.webServices.tp/")
@WebService()
public interface CalculTva {
	//@WebParam pour bien générer WSDL
	double tva(@WebParam(name="ht")double ht,@WebParam(name="taux")double taux);
	double ttc(@WebParam(name="ht")double ht,@WebParam(name="taux")double taux);
	String getAuteur();
	ResCalculTva tvaEtTtc(@WebParam(name="ht")double ht,
			             @WebParam(name="taux")double taux);
}

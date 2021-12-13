package tp.webServices.service;

import tp.webServices.dto.ResCalculTva;

public interface CalculTva {
	double tva(double ht,double taux);
	double ttc(double ht,double taux);
	String getAuteur();
	ResCalculTva tvaEtTtc(double ht,double taux);
}

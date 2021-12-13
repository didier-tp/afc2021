package tp.webServices.service;

import javax.jws.WebService;
import org.springframework.stereotype.Service;

import tp.webServices.dto.ResCalculTva;

@Service //ou bien @Component (de Spring)
@WebService(endpointInterface = "tp.webServices.service.CalculTva")
public class CalculTvaImpl implements CalculTva {
	public CalculTvaImpl() {
	}
	public double tva(double ht, double taux) {
		return ht * taux/100;
	}
	public double ttc(double ht, double taux) {
		return ht * ( 1 + taux/100 );
	}
	public String getAuteur() {
		return "didier";
	}
	public ResCalculTva tvaEtTtc(double ht, double taux) {
		double tva = ht * taux/100;
		return new ResCalculTva(tva , ht +tva);
	}
}

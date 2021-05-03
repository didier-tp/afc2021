package tp.core.bs.ejb;

import javax.ejb.Stateless;
import javax.jws.WebService;

import tp.core.bs.CalculTva;
import tp.core.bs.CalculTvaLocal;
import tp.core.bs.CalculTvaRemote;
import tp.core.dto.ResCalculTva;
//Surveiller les messages de la console Jboss pour connaître les noms
//des EJB "@Remote" enregistrés dans la partie "noms logiques JNDI" de JBOSS
//et aussi pour connaître l'URL de la description WSDL du WS SOAP
//à tester via soap-ui .
//http://localhost:8080/JeeAppCoreEjb/CalculTvaImpl (avec ?wsdl)

@Stateless
@WebService(endpointInterface = "tp.core.bs.CalculTva") //pour acces externe soap
public class CalculTvaImpl implements CalculTva , CalculTvaLocal , CalculTvaRemote {

	public CalculTvaImpl() {
	}

	public double tva(double ht, double tauxTva) {
		return ht * tauxTva/100;
	}

	public double ttc(double ht, double tauxTva)  {
		return ht * (1 + tauxTva/100);
	}

	public String getAuteur()  {
		return "didier / formateur fou";
	}

	public ResCalculTva tvaEtTtc(double ht, double tauxTva)  {
		double tva  = this.tva(ht, tauxTva);
		return new ResCalculTva(tva,ht + tva);
	}

}

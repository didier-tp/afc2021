package tp.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import tp.core.bs.CalculTva;
import tp.core.dto.ResCalculTva;

public class CalculTvaDeleguate implements CalculTva{
	
	private CalculTva caculateurWSProxy ;
	
	public CalculTvaDeleguate() {
				// appeler un WS Soap codé en java (dans le même langage)
				// on peut se passer de wsimport.
				//NB: ce code ne fonctionne que si l'interface CalculTva comporte l'annotation @WebService

		
		        //NB: valeurs des QName dans ?wsdl
				QName SERVICE_NAME = new QName("http://ejb.bs.core.tp/", "CalculTvaImplService");
				QName PORT_NAME = new QName("http://ejb.bs.core.tp/", "CalculTvaImplPort");
				// en précisant une URL WSDL connue et accessible
				
				String wdlUrl =
				"http://localhost:8080/JeeAppCoreEjb/CalculTvaImpl?wsdl";
				URL wsdlDocumentLocation=null;
				try {wsdlDocumentLocation = new URL(wdlUrl);
				} catch (MalformedURLException e) { e.printStackTrace();}
				
				//avec import javax.xml.ws.Service;
				Service service = Service.create(wsdlDocumentLocation, SERVICE_NAME);
				this.caculateurWSProxy = (CalculTva)
				                service.getPort(PORT_NAME, CalculTva.class);
	}

	@Override
	public double tva(double ht, double tauxTva) {
		return caculateurWSProxy.tva(ht, tauxTva);
	}

	@Override
	public double ttc(double ht, double tauxTva) {
		return caculateurWSProxy.ttc(ht, tauxTva);
	}

	@Override
	public ResCalculTva tvaEtTtc(double ht, double tauxTva) {
		return caculateurWSProxy.tvaEtTtc(ht, tauxTva);
	}

	@Override
	public String getAuteur() {
		return caculateurWSProxy.getAuteur();
	}

}

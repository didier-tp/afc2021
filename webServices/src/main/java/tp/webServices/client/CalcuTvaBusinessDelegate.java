package tp.webServices.client;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import tp.webServices.dto.ResCalculTva;
import tp.webServices.service.CalculTva;

public class CalcuTvaBusinessDelegate implements CalculTva{
	
	private CalculTva calculateurWSProxy=null;

	public CalcuTvaBusinessDelegate() {
		//appel de web service soap depuis code java
		QName SERVICE_NAME = new QName("http://service.webServices.tp/",
						                      "CalculTvaImplService");
		QName PORT_NAME = new QName("http://service.webServices.tp/",
						                    "CalculTvaImplPort");
		String serverHost ="localhost";
		//String serverHost = "192.168.102.117";
		// en précisant une URL WSDL connue et accessible
		String wsdlUrl="http://" + serverHost + ":8484/webServices/soap/calculTva?wsdl";
		URL wsdlDocumentLocation=null;
		try {wsdlDocumentLocation = new URL(wsdlUrl);
		} catch (MalformedURLException e) { e.printStackTrace();}
		//avec import javax.xml.ws.Service;
		Service service = Service.create(wsdlDocumentLocation, SERVICE_NAME);
		this.calculateurWSProxy = (CalculTva)
				                    service.getPort(PORT_NAME, CalculTva.class);
	}

	@Override
	public double tva(double ht, double taux) {
		return calculateurWSProxy.tva(ht, taux);
	}

	@Override
	public double ttc(double ht, double taux) {
		return calculateurWSProxy.ttc(ht, taux);
	}

	@Override
	public String getAuteur() {
		return calculateurWSProxy.getAuteur();
	}

	@Override
	public ResCalculTva tvaEtTtc(double ht, double taux) {
		return calculateurWSProxy.tvaEtTtc(ht, taux);
	}

}

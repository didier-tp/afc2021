package tp.webServices;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import tp.webServices.service.CalculTva;

public class ClientWsSoap {
	public ClientWsSoap() {
	}

	public static void main(String[] args) {
        //appel de web service soap depuis code java
		QName SERVICE_NAME = new QName("http://service.webServices.tp/",
				                      "CalculTvaImplService");
		QName PORT_NAME = new QName("http://service.webServices.tp/",
				                    "CalculTvaImplPort");
		// en précisant une URL WSDL connue et accessible
		String wsdlUrl="http://localhost:8484/webServices/soap/calculTva?wsdl";
		URL wsdlDocumentLocation=null;
		try {wsdlDocumentLocation = new URL(wsdlUrl);
		} catch (MalformedURLException e) { e.printStackTrace();}
		//avec import javax.xml.ws.Service;
		Service service = Service.create(wsdlDocumentLocation, SERVICE_NAME);
		CalculTva caculateurWSProxy = (CalculTva)
		service.getPort(PORT_NAME, CalculTva.class);
		double ttc =
		caculateurWSProxy.ttc(200.0,20.0);
		System.out.println("ttc=" + ttc);
	}

}

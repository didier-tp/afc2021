package fr.afcepf.al35.tp.service;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.afcepf.al35.serverSoap.service.Conversion;

@Component //ou bien @Service
public class ConversionServiceDelegate implements Conversion {
	
	private Conversion proxyConversion=null;
	
	@Value("${conversion.wsdl}")//conversion.wsdl=.... dans application.properties
	private String conversionWsdlUrl;
	
	@PostConstruct
	public void initConversionServiceDelegate() {
		//String sWsdlUrl="http://localhost:8484/serverSoap/service/conversion?wsdl";
		String sWsdlUrl = this.conversionWsdlUrl;
		URL wsdlUrl = null;
		try {
			wsdlUrl = new URL(sWsdlUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		try {
			QName SERVICE_NAME = new QName("http://service.serverSoap.al35.afcepf.fr/",
					                       "ConversionImplService");
			javax.xml.ws.Service service = 
					 javax.xml.ws.Service.create(wsdlUrl,SERVICE_NAME);
			//NB: Conversion.java doit comporter @WebService , @WebParam , ...
			//on a recupérer ça via la dépendance vers serverSoap-itf
			//ou bien via wsimport ....?wsdl si jdk 1.6 ou 1.7 ou 1.8
			//ou bien wsdl2java de csf ou autre
			this.proxyConversion = service.getPort(Conversion.class);
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("soap pas accessible " + e.getMessage());
		}
	}

	@Override
	public double convertir(double montant, String codeDeviseSource, String codeDeviseCible) {
		return proxyConversion.convertir(montant, codeDeviseSource, codeDeviseCible);
	}

	@Override
	public String getDev() {
		return proxyConversion.getDev();
	}

}

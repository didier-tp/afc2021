package fr.afcepf.al35.serverSoap.service;

import javax.jws.WebService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//webService Soap dont on précise l'interface SEI = "Service Endpoint Interface"
@Service //ou @Stateless sur projet EJB
@Transactional
@WebService(endpointInterface = "fr.afcepf.al35.serverSoap.service.Conversion")
public class ConversionImpl implements Conversion{

	@Override
	public double convertir(double montant, String codeDeviseSource, String codeDeviseCible) {
		// V1 (version préliminaire sans database)
		return montant * 1.5;
	}

	@Override
	public String getDev() {
		return "Didier , formteur fou";
	}

}

package fr.afcepf.al35.serverSoap.service;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al35.serverSoap.dao.DaoDevise;
import fr.afcepf.al35.serverSoap.entity.Devise;

//webService Soap dont on précise l'interface SEI = "Service Endpoint Interface"
@Service //ou @Stateless sur projet EJB
//@Transactional
@WebService(endpointInterface = "fr.afcepf.al35.serverSoap.service.Conversion")
public class ConversionImpl implements Conversion{
	
	@Autowired
	private DaoDevise daoDevise;

	@Override
	public double convertir(double montant, String codeDeviseSource, String codeDeviseCible) {
		Devise deviseSource = daoDevise.findById(codeDeviseSource).get();
		Devise deviseCible = daoDevise.findById(codeDeviseCible).get();
		return montant * deviseCible.getChange() / deviseSource.getChange();
	}

	@Override
	public String getDev() {
		return "Didier , formteur fou";
	}

}

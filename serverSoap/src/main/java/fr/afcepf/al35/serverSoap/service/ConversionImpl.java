package fr.afcepf.al35.serverSoap.service;

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

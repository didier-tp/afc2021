package fr.afcepf.al35.tp.service;

import java.util.List;

import fr.afcepf.al35.tp.dto.Devise;

public interface DeviseService {
	
	double convertir(double montant, String codeMsource, String codecible);
	List<Devise> listeDevises();
	//...

}

package fr.afcepf.al35.serverRest.service;

import java.util.List;

import fr.afcepf.al35.serverRest.entity.Devise;

public interface ServiceDevise {
   List<Devise> rechercherDevises();
   Devise rechercherDeviseParCode(String code);
   double convertir(double montant, 
		            String codeDeviseSource, 
		            String codeDeviseCible);
   //..
   Devise createDevise(Devise d);
   void updateDevise(Devise d);
   void deleteDevise(String code);
}

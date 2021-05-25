package fr.afcepf.al35.tp.service;

import java.util.List;

import fr.afcepf.al35.tp.entity.Compte;

public interface CompteService {
	List<Compte> rechercherTousLesComptes();
	Compte sauvegarderCompte(Compte cpt);
	void transferer(long numCptDeb,long numCptCred,double montant);
	List<Compte> comptesDuClient(long numClient);
	Compte rechercherCompteParNumero(long numCpt);
}

package tp.core.bs;

import java.util.List;

import tp.core.entity.Compte;

//par defaut throws RuntimeException;
public interface CompteService {
		Compte rechercherCompteSelonNumero(Long num);
		Compte rechercherCompteAvecOpSelonNumero(Long num);
		List<Compte> rechercherComptes();
		Compte ajouterCompte(Compte cpt);
		//...
		void transferer(double montant,long numCptDeb,long numCptCred);
		//..
	
}

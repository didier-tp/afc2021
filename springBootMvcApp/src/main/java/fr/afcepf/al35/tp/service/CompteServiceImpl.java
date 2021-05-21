package fr.afcepf.al35.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al35.tp.dao.CompteDao;
import fr.afcepf.al35.tp.entity.Compte;

@Service //heritant de @Component
@Transactional
public class CompteServiceImpl implements CompteService {
	
	@Autowired //ou @Inject
	private CompteDao compteDao;

	@Override
	public List<Compte> rechercherTousLesComptes() {
		return (List<Compte>) compteDao.findAll();
	}

	@Override
	public Compte sauvegarderCompte(Compte cpt) {
		return compteDao.save(cpt);
	}

	@Override
	public void transferer(long numCptDeb, long numCptCred, double montant) {
		try {
			Compte cptDeb = compteDao.findById(numCptDeb).get();
			cptDeb.setSolde(cptDeb.getSolde()-montant);
			compteDao.save(cptDeb);
			
			Compte cptCred = compteDao.findById(numCptCred).get();
			cptCred.setSolde(cptCred.getSolde()+montant);
			compteDao.save(cptCred);
		} catch (Exception e) {
			//+eventuel ajout d'une ligne de log via logger
			throw new RuntimeException("echec transfert",e);
			//throw new MyServiceException("echec transfert",e); //héritant de RuntimeException
		}
	}

	@Override
	public List<Compte> comptesDuClient(long numClient) {
		return compteDao.findByClientNumero(numClient);
	}

	@Override
	public Compte rechercherCompteParNumero(long numCpt) {
		return compteDao.findById(numCpt).orElse(null);
	}

}

package tp.core.bs.ejb;
import java.util.List;

import javax.ejb.EJBException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import tp.core.bs.CompteService;
import tp.core.dao.CompteDao;
import tp.core.entity.Compte;
import tp.core.entity.Operation;

@Local //ou bien @Remote
@Stateless //EJB Session sans etat
//@TransactionManagement(TransactionManagementType.CONTAINER) par defaut
//@TransactionAttribute(TransactionAttributeType.REQUIRED) par defaut
// equivalent à @Transactional() de Spring
public class CompteServiceImpl implements CompteService{
	
	//@EJB possible mais moins courant que @Inject
	@Inject
	private CompteDao compteDao;
	

	public CompteServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Compte rechercherCompteSelonNumero(Long num) {
		// on délègue le traitement au composant DAO
		Compte cpt  = compteDao.findCompteByNum(num);
		/*
		//INFAME BIDOUILLE:
		for(Operation op : cpt.getOperations()) {
		   //boucle for à vide pour remonter les operations en mémoire
		    //en mode lazy
		}*/
		return cpt;
	}

	@Override
	public List<Compte> rechercherComptes() {
		return compteDao.findAllComptes();
	}

	@Override
	public Compte ajouterCompte(Compte cpt) {
		return compteDao.insertCompte(cpt);
	}

	@Override
	public void transferer(double montant, long numCptDeb, long numCptCred) {
		//le code enrichi par EJB+jboss , déclenche ici
		//initialisation de entityManager + début transaction
		try {
			Compte cptDeb = compteDao.findCompteByNum(numCptDeb);
			//+ eventuelle verification solde suffisant + exception sinon
			cptDeb.setSolde(cptDeb.getSolde()-montant);
			//compteDao.updateCompte(cptDeb); //update automtique lors du futur commit
			
			Compte cptCred = compteDao.findCompteByNum(numCptCred);
			cptCred.setSolde(cptCred.getSolde()+montant);
			//compteDao.updateCompte(cptCred);
		} catch (Exception e) {
			e.printStackTrace();
			throw new EJBException("echec transfert" + e.getMessage());
		}
		//commit automatique si pas d'exception , rollback automatique sinon
		//si commit , update automatique sur tous les objets persitants modifiés
		//fermeture automatique de entityManager , les entités passent à l'état détachés
	}

	@Override
	public Compte rechercherCompteAvecOpSelonNumero(Long num) {
		return compteDao.findCompteWithOpByNum(num);
	}

}

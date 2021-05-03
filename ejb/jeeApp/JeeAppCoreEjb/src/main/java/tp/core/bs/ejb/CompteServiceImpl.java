package tp.core.bs.ejb;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import tp.core.bs.CompteService;
import tp.core.dao.CompteDao;
import tp.core.entity.Compte;

@Local //ou bien @Remote
@Stateless //EJB Session sans etat
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
		return compteDao.findCompteByNum(num);
	}

	@Override
	public List<Compte> rechercherComptes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte ajouterCompte(Compte cpt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void transferer(double montant, long numCptDeb, long numCptCred) {
		// TODO Auto-generated method stub
		
	}

}

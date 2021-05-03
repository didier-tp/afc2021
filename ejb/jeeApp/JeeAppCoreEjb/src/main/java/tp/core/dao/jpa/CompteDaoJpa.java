package tp.core.dao.jpa;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tp.core.dao.CompteDao;
import tp.core.entity.Compte;

@Local
@Stateless
public class CompteDaoJpa implements CompteDao {
	
	@PersistenceContext() //utilisable sur ebj ou bien sur composant Spring
	private EntityManager em;

	public CompteDaoJpa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Compte findCompteByNum(Long num) {
		return em.find(Compte.class, num);
	}

	@Override
	public List<Compte> findAllComptes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Compte insertCompte(Compte c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCompte(Compte c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCompte(Long num) {
		// TODO Auto-generated method stub

	}

}

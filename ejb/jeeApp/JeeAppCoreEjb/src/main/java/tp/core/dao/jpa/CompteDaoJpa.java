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
	}

	@Override
	public Compte findCompteByNum(Long num) {
		return em.find(Compte.class, num);
	}

	@Override
	public List<Compte> findAllComptes() {
		return em.createQuery("SELECT c FROM Compte c", Compte.class)
				//.setParameter(...,...)
				.getResultList();
	}

	@Override
	public Compte insertCompte(Compte c) {
		//au debut c.numero est à null (inconnu)
		this.em.persist(c);
		return c; //avec c.numero = clef primaire auto-incrémentée
	}

	@Override
	public void updateCompte(Compte c) {
		this.em.merge(c);
	}

	@Override
	public void deleteCompte(Long num) {
		Compte c= em.find(Compte.class, num);
		this.em.remove(c);
	}

}

package fr.afcepf.al35.tp.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.afcepf.al35.tp.entity.Compte;

@Repository
public class CompteDaoJpa implements CompteDao {
	
	@PersistenceContext()
	private EntityManager entityManager;

	public CompteDaoJpa() {
	}

	
	@Override
	public Optional<Compte> findById(Long id) {
		return Optional.of(entityManager.find(Compte.class, id));
	}

	@Override
	public Compte save(Compte c) {
		if(c.getNumero()==null)
			entityManager.persist(c);
		else
			entityManager.merge(c);
		return c;
	}

	@Override
	public void deleteById(Long id) {
		Compte c = entityManager.find(Compte.class, id);
		entityManager.remove(c);
	}

	@Override
	public List<Compte> findByClientNumero(long numClient) {
		return entityManager.createNamedQuery("Compte.findByClientNumero", Compte.class)
			   .setParameter("numClient", numClient)
			   .getResultList();
	}
	
	@Override
	public List<Compte> findAll() {
		return entityManager.createNamedQuery("Compte.findAll", Compte.class)
			   .getResultList();
	}

}

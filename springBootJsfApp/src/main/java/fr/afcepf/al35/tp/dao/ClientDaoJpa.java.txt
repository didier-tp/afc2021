package fr.afcepf.al35.tp.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.afcepf.al35.tp.entity.Client;
import fr.afcepf.al35.tp.entity.Compte;

@Repository
public class ClientDaoJpa implements ClientDao {
	
	@PersistenceContext()
	private EntityManager entityManager;

	public ClientDaoJpa() {
	}

	@Override
	public Optional<Client> findById(Long id) {
		return Optional.of(entityManager.find(Client.class, id));
	}

	@Override
	public Client save(Client c) {
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

}

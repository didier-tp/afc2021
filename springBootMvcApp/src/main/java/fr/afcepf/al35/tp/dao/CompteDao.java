package fr.afcepf.al35.tp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al35.tp.entity.Compte;

public interface CompteDao extends CrudRepository<Compte,Long>{
   //principales méthodes héritées : findById() , save() , deleteById() , ...
	List<Compte> findByClientNumero(long numClient);
}

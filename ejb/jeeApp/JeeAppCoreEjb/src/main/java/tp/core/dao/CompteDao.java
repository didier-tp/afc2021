package tp.core.dao;

import java.util.List;

import tp.core.entity.Compte;

//DAO = Data Access Object , CRUD

public interface CompteDao {
	Compte findCompteByNum(Long num);
	List<Compte> findAllComptes();
	Compte insertCompte(Compte c);
	void updateCompte(Compte c);
	void deleteCompte(Long num);
	//...
}

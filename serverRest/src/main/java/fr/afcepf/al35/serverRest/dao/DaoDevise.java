package fr.afcepf.al35.serverRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.afcepf.al35.serverRest.entity.Devise;

public interface DaoDevise extends JpaRepository<Devise,String>{
  //...
}

package fr.afcepf.al35.serverSoap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.afcepf.al35.serverSoap.entity.Devise;

public interface DaoDevise extends JpaRepository<Devise,String>{
  //...
}

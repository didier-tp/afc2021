package fr.afcepf.al35.serverRest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.afcepf.al35.serverRest.entity.Devise;

public interface DaoDevise extends JpaRepository<Devise,String>{
  List<Devise> findByChangeGreaterThanEqual(Double changeMini);
}

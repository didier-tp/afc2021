package fr.afcepf.al35.serverRest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.afcepf.al35.serverRest.entity.Pays;

public interface DaoPays extends JpaRepository<Pays,String>{
  
}
